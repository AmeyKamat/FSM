package fsm.RestControllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import fsm.domain.Country;
import fsm.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Set;

/**
 * Created by Mohit on 11/15/2016.
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HierarchyRest {

    @Autowired
    private CountryService countryService;


    @GET
    @Path("/uploadHierarchy")
    public String getUploadHierarchy() throws JsonProcessingException {
    List<Country> countries=countryService.getAllCountries();
        SimpleBeanPropertyFilter theFilter = SimpleBeanPropertyFilter.serializeAllExcept("floors");
        FilterProvider filters = new SimpleFilterProvider().addFilter("locationFilter", theFilter);
        ObjectMapper objectMapper=new ObjectMapper();
        return  objectMapper.writer(filters).writeValueAsString(countries);
    }


    @GET
    @Path("/floorHierarchy")
    public String getFloorHierarchy() throws JsonProcessingException {
        List<Country> countries=countryService.getAllCountries();
        String[] propIgnore={"id","location","minX","minY","maxX","maxY","tables"};
        SimpleBeanPropertyFilter theFilter = SimpleBeanPropertyFilter.serializeAllExcept(propIgnore);
        FilterProvider filters = new SimpleFilterProvider().addFilter("floorFilter", theFilter);
        ObjectMapper objectMapper=new ObjectMapper();
        return objectMapper.writer(filters).writeValueAsString(countries);
    }



}