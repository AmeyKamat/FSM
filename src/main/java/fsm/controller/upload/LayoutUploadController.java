package fsm.controller.upload;


import fsm.model.domain.Floor;
import fsm.model.session.UnpublishedLayout;
import fsm.service.FloorService;
import fsm.service.ParsingService;
import fsm.util.FileUploadHelper;
import fsm.util.JsonFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@Scope("request")
@RequestMapping(value = "/layoutFile")
public class LayoutUploadController {

    @Autowired
    UnpublishedLayout unpublishedLayout;

    @Autowired
    ParsingService parsingService;

    @Autowired
    FloorService floorService;

    @Value("${upload.location}")
    String fileDirectory;

    @RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public String uploadLayoutFile(@RequestParam("file") MultipartFile multipartFile, @RequestParam("floorId") int floorId) {

        File file = null;
        if (!multipartFile.isEmpty()) {
            file = FileUploadHelper.storeFile(multipartFile, multipartFile.getOriginalFilename(), fileDirectory);

        }

        unpublishedLayout.setFloor(parsingService.parseLayout(file));
        unpublishedLayout.setFloorId(floorId);

        String[] propsToBeIgnored = {};
        return JsonFilter.filter(unpublishedLayout.getFloor(), propsToBeIgnored);
    }

    @RequestMapping(value = "/publish", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void publishLayout(@RequestParam("toBePublished") boolean toBePublished) {
        if(toBePublished) {
            Floor floor = unpublishedLayout.getFloor();
            floor.setId(unpublishedLayout.getFloorId());
            floorService.updateFloor(floor);
        }

        unpublishedLayout.setFloor(null);
    }
}


