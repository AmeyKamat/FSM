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


@RestController
public class LocationRestEndPoints {


    @Autowired
    private LocationService locationService;

    @GetMapping(value = "/city/{cityId}/locations/", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getLocationsByCity(@PathVariable("cityId") int cityId) throws JsonProcessingException {
        List<Location> locations = locationService.getAllLocations(cityId);
        String[] ignoreProperties = {"floors", "city"};
        SimpleBeanPropertyFilter locationFilter = SimpleBeanPropertyFilter.serializeAllExcept(ignoreProperties);
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("locationFilter", locationFilter);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setFilterProvider(filterProvider);
        return objectMapper.writer(filterProvider).writeValueAsString(locations);
    }


    @GetMapping(value = "/locations/{locationId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getLocation(@PathVariable("locationId") int locationId) throws JsonProcessingException {
        Location location = locationService.getLocationById(locationId);
        String[] ignoreProperties = {"floors", "city"};
        SimpleBeanPropertyFilter locationFilter = SimpleBeanPropertyFilter.serializeAllExcept(ignoreProperties);
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("locationFilter", locationFilter);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setFilterProvider(filterProvider);
        return objectMapper.writer(filterProvider).writeValueAsString(location);
    }


}
