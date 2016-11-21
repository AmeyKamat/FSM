package fsm.controller.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import fsm.domain.Country;
import fsm.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Mohit on 11/21/2016.
 */
@RestController
public class CountryRestEndpoints {
    @Autowired
    private CountryService countryService;

    @GetMapping(value = "/country",produces = MediaType.APPLICATION_JSON_VALUE)
    public String getHierarchyCountry() throws JsonProcessingException {
        List<Country> countries=countryService.getAllCountries();
        SimpleBeanPropertyFilter countryFilter = SimpleBeanPropertyFilter.serializeAllExcept("cities");
        FilterProvider filters = new SimpleFilterProvider().addFilter("countryFilter", countryFilter);
        ObjectMapper objectMapper=new ObjectMapper();
        return  objectMapper.writer(filters).writeValueAsString(countries);
    }


    @GetMapping(value = "/country/{countryId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public String getHierarchyCountry(@PathVariable("countryId") int countryId) throws JsonProcessingException {
        Country country=countryService.getCountryById(countryId);
        SimpleBeanPropertyFilter countryFilter = SimpleBeanPropertyFilter.serializeAllExcept("cities");
        FilterProvider filters = new SimpleFilterProvider().addFilter("countryFilter", countryFilter);
        ObjectMapper objectMapper=new ObjectMapper();
        return  objectMapper.writer(filters).writeValueAsString(country);
    }


    @GetMapping(value = "/Hierarchy",produces = MediaType.APPLICATION_JSON_VALUE)
    public String getHierarchyEverything() throws JsonProcessingException {
        List<Country> countries=countryService.getAllCountries();
        // SimpleBeanPropertyFilter theFilter = SimpleBeanPropertyFilter.serializeAllExcept("floors");
        // FilterProvider filters = new SimpleFilterProvider().addFilter("locationFilter", theFilter);
        ObjectMapper objectMapper=new ObjectMapper();
        return  objectMapper.writer().writeValueAsString(countries);
    }

}
