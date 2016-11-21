package fsm.controller.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import fsm.domain.City;
import fsm.domain.Country;
import fsm.domain.Floor;
import fsm.domain.Location;
import fsm.service.CityService;
import fsm.service.CountryService;
import fsm.service.FloorService;
import fsm.service.LocationService;
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
//@RestController
public class HierarchyRest {

    @Autowired
    private CountryService countryService;

    @Autowired
    private CityService cityService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private FloorService floorService;
/*
    @GetMapping(value = "/Hello",produces = MediaType.APPLICATION_JSON_VALUE)
    public String helloWorld() throws JsonProcessingException {
    return "Hello World";
    }*/

/*

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

*/

/*
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


*/
  /*  @RequestMapping(value = "/country/{countryId}/city/{cityId}/location/{locationId}/floor/",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String getHierarchyFloor() throws JsonProcessingException {
        List<Floor> floors=floorService.getAllFloors();
        String[] propIgnore={"location","minX","minY","maxX","maxY","tables"};
        SimpleBeanPropertyFilter floorFilter = SimpleBeanPropertyFilter.serializeAllExcept(propIgnore);
        FilterProvider filters = new SimpleFilterProvider().addFilter("floorFilter", floorFilter);
        ObjectMapper objectMapper=new ObjectMapper();
        return objectMapper.writer(filters).writeValueAsString(floors);
    }


    @RequestMapping(value = "/country/{countryId}/city/{cityId}/location/{locationId}/floor/{floorId}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public String getHierarchyFloors(@PathVariable("floorId") int floorId) throws JsonProcessingException {
        Floor floor=floorService.getFloorById(floorId);
        String[] propIgnore={"location"};
        SimpleBeanPropertyFilter theFilter = SimpleBeanPropertyFilter.serializeAllExcept(propIgnore);
        FilterProvider filters = new SimpleFilterProvider().addFilter("floorFilter", theFilter);
        ObjectMapper objectMapper=new ObjectMapper();
        return objectMapper.writer(filters).writeValueAsString(floor);
    }


*/
/*
    @GetMapping(value = "/Hierarchy",produces = MediaType.APPLICATION_JSON_VALUE)
    public String getHierarchyEverything() throws JsonProcessingException {
        List<Country> countries=countryService.getAllCountries();
        // SimpleBeanPropertyFilter theFilter = SimpleBeanPropertyFilter.serializeAllExcept("floors");
        // FilterProvider filters = new SimpleFilterProvider().addFilter("locationFilter", theFilter);
        ObjectMapper objectMapper=new ObjectMapper();
        return  objectMapper.writer().writeValueAsString(countries);
    }
*/



    /*@GetMapping(value = "/country/city",produces = MediaType.APPLICATION_JSON_VALUE)
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
*/
   /* @GetMapping(value = "/country/city/location/",produces = MediaType.APPLICATION_JSON_VALUE)
    public String getHierarchyLocation() throws JsonProcessingException {
        List<Location> locations=locationService.getAllLocations();
        String[] ignoreProperties={"city","floors"};
        SimpleBeanPropertyFilter theFilter = SimpleBeanPropertyFilter.serializeAllExcept(ignoreProperties);
        FilterProvider filters = new SimpleFilterProvider().addFilter("locationFilter", theFilter);
        ObjectMapper objectMapper=new ObjectMapper();
        return  objectMapper.writer(filters).writeValueAsString(locations);
    }

*/
}