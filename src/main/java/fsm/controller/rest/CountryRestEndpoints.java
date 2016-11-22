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


@RestController
public class CountryRestEndpoints {
    @Autowired
    private CountryService countryService;

    @GetMapping(value = "/countries", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getCountries() throws JsonProcessingException {
        List<Country> countries = countryService.getAllCountries();
        SimpleBeanPropertyFilter countryFilter = SimpleBeanPropertyFilter.serializeAllExcept("cities");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("countryFilter", countryFilter);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writer(filterProvider).writeValueAsString(countries);
    }


    @GetMapping(value = "/countries/{countryId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getCountry(@PathVariable("countryId") int countryId) throws JsonProcessingException {
        Country country = countryService.getCountryById(countryId);
        SimpleBeanPropertyFilter countryFilter = SimpleBeanPropertyFilter.serializeAllExcept("cities");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("countryFilter", countryFilter);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writer(filterProvider).writeValueAsString(country);
    }


}
