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
import fsm.model.domain.Country;
import fsm.service.CountryService;
import fsm.util.JsonFilter;

@RestController
@RequestMapping(value = "/countries")
public class CountryRestController {

	@Autowired
	private CountryService countryService;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getAllCountries() throws JsonProcessingException {
		List<Country> countries = countryService.getAllCountries();
		String[] propsToBeIgnored = { "cities" };
		return JsonFilter.filter(countries, propsToBeIgnored);
	}

	@RequestMapping(value = "/{countryId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getCountryById(@PathVariable("countryId") int countryId) throws JsonProcessingException {
		Country country = countryService.getCountryById(countryId);
		String[] propsToBeIgnored = { "cities" };
		return JsonFilter.filter(country, propsToBeIgnored);
	}

	@RequestMapping(value = "/{countryId}/cities", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String getCitiesInCountry(@PathVariable("countryId") int countryId) throws JsonProcessingException {
		List<City> cities = countryService.getCountryById(countryId).getCities();
		String[] propsToBeIgnored = { "country", "locations" };
		return JsonFilter.filter(cities, propsToBeIgnored);
	}
}
