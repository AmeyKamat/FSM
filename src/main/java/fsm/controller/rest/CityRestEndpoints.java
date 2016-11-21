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
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Mohit on 11/21/2016.
 */
@RestController
public class CityRestEndpoints {

    @Autowired
    private CityService cityService;

    @GetMapping(value = "/country/{countryId}/city/",produces = MediaType.APPLICATION_JSON_VALUE)
    public String getHierarchyCities(@PathVariable("countryId") int countryId) throws JsonProcessingException {
        List<City> cities=cityService.getAllCities(countryId);
        String[] ignoreProperties={"country","locations"};
        SimpleBeanPropertyFilter cityFilter = SimpleBeanPropertyFilter.serializeAllExcept(ignoreProperties);
        FilterProvider filters = new SimpleFilterProvider().addFilter("cityFilter", cityFilter);
        ObjectMapper objectMapper=new ObjectMapper();
        return  objectMapper.writer(filters).writeValueAsString(cities);
    }


    @GetMapping(value = "/country/{countryId}/city/{cityId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public String getHierarchyCity(@PathVariable("cityId") int cityId) throws JsonProcessingException {
        City city=cityService.getCityById(cityId);
        String[] ignoreProperties={"country","locations"};
        SimpleBeanPropertyFilter cityFilter = SimpleBeanPropertyFilter.serializeAllExcept(ignoreProperties);
        FilterProvider filters = new SimpleFilterProvider().addFilter("cityFilter", cityFilter);
        ObjectMapper objectMapper=new ObjectMapper();
        return  objectMapper.writer(filters).writeValueAsString(city);
    }

    @GetMapping(value = "/country/city",produces = MediaType.APPLICATION_JSON_VALUE)
    public String getHierarchyCities() throws JsonProcessingException {
        List<City> cities=cityService.getAllCities();
        System.out.println("test city rest service");
        String[] ignoreProperties={"country","locations"};
        SimpleBeanPropertyFilter theFilter = SimpleBeanPropertyFilter.serializeAllExcept(ignoreProperties);
        FilterProvider filters = new SimpleFilterProvider().addFilter("cityFilter", theFilter);
        ObjectMapper objectMapper=new ObjectMapper();
        return  objectMapper.writer(filters).writeValueAsString(cities);
//        return "Hello World";
    }



}
