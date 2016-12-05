package fsm.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import fsm.model.domain.Floor;
import fsm.service.FloorService;
import fsm.util.JsonFilter;


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
}
