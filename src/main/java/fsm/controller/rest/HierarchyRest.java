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
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;


import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON;

/**
 * Created by Mohit on 11/15/2016.
 */
//@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)  //Jersey
@RestController
public class HierarchyRest {

    @Autowired
    private CountryService countryService;


    @GetMapping(value = "/Hello",produces = MediaType.APPLICATION_JSON_VALUE)
    public String helloWorld() throws JsonProcessingException {
    return "Hello World";
    }


    @GetMapping(value = "/uploadHierarchy",produces = MediaType.APPLICATION_JSON_VALUE)
    public String getUploadHierarchy() throws JsonProcessingException {
    List<Country> countries=countryService.getAllCountries();
        SimpleBeanPropertyFilter theFilter = SimpleBeanPropertyFilter.serializeAllExcept("floors");
        FilterProvider filters = new SimpleFilterProvider().addFilter("locationFilter", theFilter);
        ObjectMapper objectMapper=new ObjectMapper();
        return  objectMapper.writer(filters).writeValueAsString(countries);
    }


    @RequestMapping(value = "/floorHierarchy",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String getFloorHierarchy() throws JsonProcessingException {
        List<Country> countries=countryService.getAllCountries();
        String[] propIgnore={"id","location","minX","minY","maxX","maxY","tables"};
        SimpleBeanPropertyFilter theFilter = SimpleBeanPropertyFilter.serializeAllExcept(propIgnore);
        FilterProvider filters = new SimpleFilterProvider().addFilter("floorFilter", theFilter);
        ObjectMapper objectMapper=new ObjectMapper();
        return objectMapper.writer(filters).writeValueAsString(countries);
    }



}