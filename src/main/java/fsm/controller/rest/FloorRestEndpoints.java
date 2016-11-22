package fsm.controller.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import fsm.domain.Desk;
import fsm.domain.Floor;
import fsm.domain.Location;
import fsm.domain.Table;
import fsm.domain.UI.FloorObjects;
import fsm.service.LocationService;
import fsm.service.impl.ExcelParser;
import fsm.service.impl.TableGenerator;
import fsm.service.DeskService;
import fsm.service.FloorService;
import fsm.service.TableService;
import fsm.util.PropertiesUtil;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RestController
public class FloorRestEndpoints {

    @Autowired
    FloorService floorService;

    @Autowired
    TableService tableService;

    @Autowired
    DeskService deskService;

    @Autowired
    LocationService locationService;

    @Autowired
    ExcelParser excelParser;

    @Autowired
    TableGenerator tableGenerator;


    @RequestMapping(value = "/location/{locationId}/floors", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getFloorsByLocation(@PathVariable("locationId") int locationId) throws JsonProcessingException {

        List<Floor> floors = floorService.getAllFloors(locationId);
        String[] propIgnore = {"location", "minX", "minY", "maxX", "maxY", "tables"};
        SimpleBeanPropertyFilter floorFilter = SimpleBeanPropertyFilter.serializeAllExcept(propIgnore);
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("floorFilter", floorFilter);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writer(filterProvider).writeValueAsString(floors);
    }


    @RequestMapping(value = "/floors/{floorId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getFloor(@PathVariable("floorId") int floorId) throws JsonProcessingException {
        Floor floor = floorService.getFloorById(floorId);
        String[] propIgnore = {"location"};
        SimpleBeanPropertyFilter theFilter = SimpleBeanPropertyFilter.serializeAllExcept(propIgnore);
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("floorFilter", theFilter);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writer(filterProvider).writeValueAsString(floor);
    }


    @PostMapping(value = "/file/upload")
    @ResponseStatus(value = HttpStatus.OK)
    public void uploadFile(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        int locationId = Integer.parseInt(request.getParameter("locationId"));
        String floorCode = request.getParameter("floorCode");
        httpSession.setAttribute("locationId", locationId);
        httpSession.setAttribute("floorCode", floorCode);


        int maxFileSize = Integer.parseInt(PropertiesUtil.readProperty("max-FileSize"));
        int maxMemSize = Integer.parseInt(PropertiesUtil.readProperty("max-MemSize"));
        String fileDirectory = PropertiesUtil.readProperty("file-upload");

        String contentType = request.getContentType();

        if ((contentType.indexOf("multipart/form-data") >= 0)) {

            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(maxMemSize);
            factory.setRepository(new java.io.File(fileDirectory)); // uploading a file to
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setSizeMax(maxFileSize);
            List fileItems = null;
            try {
                fileItems = upload.parseRequest(request);
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
            String filePath = fsm.util.File.store(fileItems, fileDirectory);
            httpSession.setAttribute("filePath", filePath);
        }


    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/floor/unpublished")
    public String getUnPublishedFloor(HttpServletRequest request) throws JsonProcessingException {

        HttpSession httpSession = request.getSession();
        int locationId = (Integer) request.getAttribute("locationId");
        String floorCode = (String) request.getAttribute("floorCode");
        String filePath = (String) request.getAttribute("filePath");

        Location location = locationService.getLocationById(locationId);
        FloorObjects parsingData = excelParser.parseFloorDetails(filePath);
        List<Table> tableList = tableGenerator.DFS_UTIL(parsingData);
        parsingData.updateFloor(location, floorCode, new HashSet(tableList));
        Floor floor = parsingData.getFloor();

        httpSession.setAttribute("floor", floor);
        httpSession.removeAttribute("locationId");
        httpSession.removeAttribute("floorCode");
        httpSession.removeAttribute("filePath");

        SimpleBeanPropertyFilter floorFilter = SimpleBeanPropertyFilter.serializeAllExcept("location");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("floorFilter", floorFilter);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writer(filterProvider).writeValueAsString(floor);
    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/floor/publish")
    public boolean publishFloor(boolean publish, HttpServletRequest httpServletRequest) {

        HttpSession httpSession = httpServletRequest.getSession();
        Floor floor = (Floor) httpSession.getAttribute("floor");

        if (publish) {
            if (floor == null)
                return false;

            floorService.addFloor(floor);
            Set<Table> tableList = floor.getTables();
            tableService.addAllTables(tableList);

            for (Table t : tableList) {
                Set<Desk> temp = t.getDesks();
                deskService.addAllDesk(temp);
            }
            httpSession.removeAttribute("floor");
            return true;

        }
        httpSession.removeAttribute("floor");
        return false;

    }


}
