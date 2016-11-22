package fsm.controller.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import fsm.domain.City;
import fsm.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityRestEndpoints {

    @Autowired
    private CityService cityService;

    @GetMapping(value = "/countries/{countryId}/cities/", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getCities(@PathVariable("countryId") int countryId) throws JsonProcessingException {
        List<City> cities = cityService.getAllCities(countryId);
        String[] ignoreProperties = {"country", "locations"};
        SimpleBeanPropertyFilter cityFilter = SimpleBeanPropertyFilter.serializeAllExcept(ignoreProperties);
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("cityFilter", cityFilter);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writer(filterProvider).writeValueAsString(cities);
    }


    @GetMapping(value = "/cities/{cityId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getCity(@PathVariable("cityId") int cityId) throws JsonProcessingException {
        City city = cityService.getCityById(cityId);
        String[] ignoreProperties = {"country", "locations"};
        SimpleBeanPropertyFilter cityFilter = SimpleBeanPropertyFilter.serializeAllExcept(ignoreProperties);
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("cityFilter", cityFilter);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writer(filterProvider).writeValueAsString(city);
    }


}
