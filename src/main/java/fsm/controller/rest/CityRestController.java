package fsm.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import fsm.model.domain.City;
import fsm.model.domain.Location;
import fsm.service.CityService;
import fsm.util.JsonFilter;

@RestController
@RequestMapping(value = "/cities")
public class CityRestController {

	@Autowired
	private CityService cityService;

	@RequestMapping(value = "/{cityId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getCityById(@PathVariable("cityId") int cityId) throws JsonProcessingException {

		City city = cityService.getCityById(cityId);
		String[] propsToBeIgnored = { "country", "locations" };
		return JsonFilter.filter(city, propsToBeIgnored);
	}

	@RequestMapping(value = "/{cityId}/locations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getLocationsInACity(@PathVariable("cityId") int cityId) throws JsonProcessingException {

		List<Location> locations = cityService.getCityById(cityId).getLocations();
		String[] propsToBeIgnored = { "floors", "city" };
		return JsonFilter.filter(locations, propsToBeIgnored);
	}
}
