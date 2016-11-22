package fsm.controller.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import fsm.domain.Desk;
import fsm.domain.Floor;
import fsm.domain.Table;
import fsm.domain.UI.UploadInfo;
import fsm.service.DeskService;
import fsm.service.FloorService;
import fsm.service.TableService;
import fsm.util.PropertiesUtil;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.hibernate.annotations.Tables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;
import java.util.Set;

/**
 * Created by Mohit on 11/21/2016.
 */
@RestController
public class FloorRestEndpoints {

    @Autowired
    FloorService floorService;

    @Autowired
    TableService tableService;

    @Autowired
    DeskService deskService;


    @RequestMapping(value = "/country/{countryId}/city/{cityId}/location/{locationId}/floor/",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String getHierarchyFloor() throws JsonProcessingException {
        List<Floor> floors=floorService.getAllFloors();
        String[] propIgnore={"location","minX","minY","maxX","maxY","tables"};
        SimpleBeanPropertyFilter floorFilter = SimpleBeanPropertyFilter.serializeAllExcept(propIgnore);
        FilterProvider filters = new SimpleFilterProvider().addFilter("floorFilter", floorFilter);
        ObjectMapper objectMapper=new ObjectMapper();
        return objectMapper.writer(filters).writeValueAsString(floors);
    }


    @RequestMapping(value = "/country/{countryId}/city/{cityId}/location/{locationId}/floor/{floorId}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String getHierarchyFloors(@PathVariable("floorId") int floorId) throws JsonProcessingException {
        Floor floor=floorService.getFloorById(floorId);
        String[] propIgnore={"location"};
        SimpleBeanPropertyFilter theFilter = SimpleBeanPropertyFilter.serializeAllExcept(propIgnore);
        FilterProvider filters = new SimpleFilterProvider().addFilter("floorFilter", theFilter);
        ObjectMapper objectMapper=new ObjectMapper();
        return objectMapper.writer(filters).writeValueAsString(floor);
    }

    @RequestMapping(value = "/country/{countryId}/city/{cityId}/location/{locationId}/floor/{floorId}/tables",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String getHierarchyTables() throws JsonProcessingException {
        Set<Table> tables=tableService.getAllTables();
        //String[] propIgnore={"location"};
        //SimpleBeanPropertyFilter theFilter = SimpleBeanPropertyFilter.serializeAllExcept(propIgnore);
        //FilterProvider filters = new SimpleFilterProvider().addFilter("floorFilter", theFilter);
        ObjectMapper objectMapper=new ObjectMapper();
        return objectMapper.writer().writeValueAsString(tables);
    }

    @RequestMapping(value = "/country/{countryId}/city/{cityId}/location/{locationId}/floor/{floorId}/tables/{tableId}/desks",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String getHierarchyDesks() throws JsonProcessingException {
        Set<Desk> desks=deskService.getAllDesks();
        String[] propIgnore={"table","deskEmployee","x","y","width","height"};
        SimpleBeanPropertyFilter theFilter = SimpleBeanPropertyFilter.serializeAllExcept(propIgnore);
        FilterProvider filters = new SimpleFilterProvider().addFilter("deskFilter", theFilter);
        ObjectMapper objectMapper=new ObjectMapper();
        return objectMapper.writer(filters).writeValueAsString(desks);
    }

    @RequestMapping(value = "/country/{countryId}/city/{cityId}/location/{locationId}/floor/{floorId}/tables/{tableId}/desks/{deskId}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String getHierarchyDesk(@PathVariable("deskId") int deskId) throws JsonProcessingException {
        Desk desk=deskService.getDeskById(deskId);
        String[] propIgnore={"table","deskEmployee","x","y","width","height"};
        SimpleBeanPropertyFilter theFilter = SimpleBeanPropertyFilter.serializeAllExcept(propIgnore);
        FilterProvider filters = new SimpleFilterProvider().addFilter("deskFilter", theFilter);
        ObjectMapper objectMapper=new ObjectMapper();
        return objectMapper.writer(filters).writeValueAsString(desk);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,value ="/country/{countryId}/city/{cityId}/location/{locationId}/floor/publish" )
    public boolean publishFloorDetails(boolean publish,HttpServletRequest httpServletRequest){

        HttpSession httpSession=httpServletRequest.getSession();
        Floor floor=(Floor)httpSession.getAttribute("floor");

        if(publish){

            if(floor==null)
                return false;

            floorService.addFloor(floor);
            Set<Table> tableList=floor.getTables();
            tableService.addAllTables(tableList);

            for(Table t: tableList){
                Set<Desk> temp=t.getDesks();
                deskService.addAllDesk(temp);
            }
            httpSession.removeAttribute("floor");
            return true;

        }
        httpSession.removeAttribute("floor");
        return false;
    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,value = "/country/{countryId}/city/{cityId}/location/{locationId}/floor/parse")
    public String storingFileThatContainsFloorInformation(HttpServletRequest request) throws JsonProcessingException {
        HttpSession httpSession=request.getSession();
        Floor floor=null;
        //accept floorCode and locationId
        String fileName=null;

        int maxFileSize = 5000 * 1024;
        int maxMemSize = 5000 * 1024;

        String filePath = PropertiesUtil.readProperty("file-upload");
        System.out.println(filePath);

        // Verify the content type
        String contentType = request.getContentType();

        if ((contentType.indexOf("multipart/form-data") >= 0)) {

            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(maxMemSize);

            // TO DO: Better to pick this up from *.application file
            factory.setRepository(new File(filePath)); // uploading a file to
            // context path
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setSizeMax(maxFileSize);
            try {

                List fileItems = upload.parseRequest(request);
                int locationId=Integer.parseInt(request.getParameter("locationId"));
                String floorCode=request.getParameter("floorCode");
                floor=floorService.storeFile(new UploadInfo(fileItems,fileName,locationId,floorCode));


            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        httpSession.setAttribute("floor",floor);
        SimpleBeanPropertyFilter theFilter = SimpleBeanPropertyFilter.serializeAllExcept("location");
        FilterProvider filters = new SimpleFilterProvider().addFilter("floorFilter", theFilter);
        ObjectMapper objectMapper=new ObjectMapper();
        return objectMapper.writer(filters).writeValueAsString(floor);
    }



}
