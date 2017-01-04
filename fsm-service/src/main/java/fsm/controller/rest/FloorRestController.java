package fsm.controller.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import fsm.model.domain.Floor;
import fsm.service.FloorService;
import fsm.util.JsonFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/floors")
public class FloorRestController {

    @Autowired
    FloorService floorService;

    @RequestMapping(value = "/{floorId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getFloorById(@PathVariable("floorId") int floorId) throws JsonProcessingException {
        Floor floor = floorService.getFloorById(floorId);
        String[] propsToBeIgnored = {"location"};
        return JsonFilter.filter(floor, propsToBeIgnored);
    }

    @RequestMapping(value = "/{floorId}/doesPlanExist", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean doesFloorPlanExist(@PathVariable("floorId") int floorId) throws JsonProcessingException {
        int countTables = floorService.getFloorById(floorId).getTables().size();
        return (countTables > 0);
    }
}
