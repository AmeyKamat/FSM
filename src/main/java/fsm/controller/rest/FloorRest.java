package fsm.controller.rest;

import java.io.File;
import java.util.*;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import fsm.domain.Desk;
import fsm.domain.Floor;
import fsm.domain.Location;
import fsm.domain.Table;
import fsm.domain.UI.UploadInfo;
import fsm.service.CountryService;
import fsm.service.DeskService;
import fsm.service.FloorService;
import fsm.service.TableService;
import fsm.service.impl.ExcelParser;
import fsm.service.impl.TableGenerator;
import fsm.util.PropertiesUtil;
import jdk.nashorn.api.scripting.JSObject;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

//@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
@RestController
public class FloorRest {


	@Autowired
	FloorService floorService;

	@Autowired
	TableService tableService;

	@Autowired
	DeskService deskService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,value = "hello")
    public String HelloWorld() {
        return "Hello World";
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,value = "getFloorData")
    public String getParsingInformation(@PathVariable int floorId) throws JsonProcessingException {
		Floor floor=floorService.getFloorById(floorId);
		SimpleBeanPropertyFilter theFilter = SimpleBeanPropertyFilter.serializeAllExcept("location");
		FilterProvider filters = new SimpleFilterProvider().addFilter("floorFilter", theFilter);
		ObjectMapper objectMapper=new ObjectMapper();
		return objectMapper.writer(filters).writeValueAsString(floor);
	}


	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,value ="publishFloorData" )
	public boolean publishFloorDetails(boolean publish,HttpServletRequest httpServletRequest){

        HttpSession httpSession=httpServletRequest.getSession();
        Floor floor=(Floor)httpSession.getAttribute("floor");

        if(publish){

			if(floor==null)
				return false;

			floorService.addFloor(floor);
			List<Table> tableList=floor.getTables();
			tableService.addAllTables(tableList);

			for(Table t: tableList){
				List<Desk> temp=t.getDesks();
				deskService.addAllDesk(temp);
			}

		httpSession.removeAttribute("floor");
		return true;

		}
		return false;
	}


	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,value = "parseFloorInformation")
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



    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,value = "parseFloorInformationTesting")
    public String storingFileThatContainsFloor() throws JsonProcessingException {
        Floor floor=floorService.parseInformationForTesting("C:\\Users\\Mohit\\Documents\\GitHub\\FSM\\doc\\FloorPlan.xls");

        SimpleBeanPropertyFilter theFilter = SimpleBeanPropertyFilter.serializeAllExcept("location");
        FilterProvider filters = new SimpleFilterProvider().addFilter("floorFilter", theFilter);
        ObjectMapper objectMapper=new ObjectMapper();
        return objectMapper.writer(filters).writeValueAsString(floor);
    }


}
