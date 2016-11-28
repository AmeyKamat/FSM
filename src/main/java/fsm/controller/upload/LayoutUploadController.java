package fsm.controller.upload;


import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import fsm.model.response.UnpublishedLayoutResponse;
import fsm.util.FileUploadHelper;
import fsm.util.PropertiesUtil;

@RestController
@Scope("request")
@RequestMapping(value = "/layoutFile")
public class LayoutUploadController {
	
	@Autowired 
	UnpublishedLayoutResponse unpublishedLayoutResponse;

	@RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public String uploadLayoutFile(@RequestParam("file") MultipartFile multipartFile, 
    		@RequestParam("locationId") int locationId, 
    		@RequestParam("floorCode") String floorCode) {
		
		//int maxFileSize = Integer.parseInt(PropertiesUtil.readProperty("max-FileSize"));
        //int maxMemSize = Integer.parseInt(PropertiesUtil.readProperty("max-MemSize"));
        String fileDirectory = PropertiesUtil.readProperty("file-upload");
        
        File file = null;
        if(!multipartFile.isEmpty()){
        	file = FileUploadHelper.storeFile(multipartFile, multipartFile.getOriginalFilename(), fileDirectory);
        	
        }
        
        System.out.println(file.getTotalSpace());
		return null;
	}
   


    /*@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/floor/unpublished")
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


}*/
}
