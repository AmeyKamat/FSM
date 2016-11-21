package fsm.controller.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import fsm.domain.Location;
import fsm.service.LocationService;
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
public class LocationRestEndPoints {


    @Autowired
    private LocationService locationService;

    @GetMapping(value = "/country/{countryId}/city/{cityId}/location/",produces = MediaType.APPLICATION_JSON_VALUE)
    public String getHierarchyLocations(@PathVariable("cityId") int cityId) throws JsonProcessingException {
        List<Location> locations=locationService.getAllLocations(cityId);
        String[] ignoreProperties={"floors","city"};
        SimpleBeanPropertyFilter locationFilter = SimpleBeanPropertyFilter.serializeAllExcept(ignoreProperties);
        FilterProvider filters = new SimpleFilterProvider().addFilter("locationFilter", locationFilter);
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.setFilterProvider(filters);
        return  objectMapper.writer(filters).writeValueAsString(locations);
    }



    @GetMapping(value = "/country/{countryId}/city/{cityId}/location/{locationId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public String getHierarchyLocation(@PathVariable("locationId") int locationId) throws JsonProcessingException {
        Location location=locationService.getLocationById(locationId);
        String[] ignoreProperties={"floors","city"};
        SimpleBeanPropertyFilter locationFilter = SimpleBeanPropertyFilter.serializeAllExcept(ignoreProperties);
        FilterProvider filters = new SimpleFilterProvider().addFilter("locationFilter", locationFilter);
        ObjectMapper objectMapper=new ObjectMapper();
        objectMapper.setFilterProvider(filters);
        return  objectMapper.writer(filters).writeValueAsString(location);
    }


    @GetMapping(value = "/country/city/location/",produces = MediaType.APPLICATION_JSON_VALUE)
    public String getHierarchyLocation() throws JsonProcessingException {
        List<Location> locations=locationService.getAllLocations();
        String[] ignoreProperties={"city","floors"};
        SimpleBeanPropertyFilter theFilter = SimpleBeanPropertyFilter.serializeAllExcept(ignoreProperties);
        FilterProvider filters = new SimpleFilterProvider().addFilter("locationFilter", theFilter);
        ObjectMapper objectMapper=new ObjectMapper();
        return  objectMapper.writer(filters).writeValueAsString(locations);
    }


}
