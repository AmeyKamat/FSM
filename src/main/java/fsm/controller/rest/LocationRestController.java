package fsm.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import fsm.model.domain.Floor;
import fsm.model.domain.Location;
import fsm.service.LocationService;
import fsm.util.JsonFilter;

@RestController
@RequestMapping(value = "/locations")
public class LocationRestController {

	@Autowired
	private LocationService locationService;

	@RequestMapping(value = "/{locationId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getLocationById(@PathVariable("locationId") int locationId) throws JsonProcessingException {
		Location location = locationService.getLocationById(locationId);
		String[] propsToBeIgnored = { "floors", "city" };
		return JsonFilter.filter(location, propsToBeIgnored);
	}

	@RequestMapping(value = "/{locationId}/floors", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getFloorsByLocation(@PathVariable("locationId") int locationId) throws JsonProcessingException {
		List<Floor> floors = locationService.getLocationById(locationId).getFloors();
		String[] propsToBeIgnored = { "location", "minX", "minY", "maxX", "maxY", "tables" };
		return JsonFilter.filter(floors, propsToBeIgnored);
	}

}
