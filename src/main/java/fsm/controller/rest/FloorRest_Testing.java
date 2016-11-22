package fsm.controller.rest;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import fsm.domain.Desk;
import fsm.domain.Floor;
import fsm.domain.Table;
import fsm.domain.UI.FloorObjects;
import fsm.service.DeskService;
import fsm.service.FloorService;
import fsm.service.LocationService;
import fsm.service.TableService;
import fsm.service.impl.ExcelParser;
import fsm.service.impl.TableGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class FloorRest_Testing {


    @Autowired
    FloorService floorService;

    @Autowired
    TableService tableService;

    @Autowired
    DeskService deskService;

    @Autowired
    LocationService locationService;

    @Autowired
    ExcelParser excelParser;

    @Autowired
    TableGenerator tableGenerator;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "publish")
    public boolean publishFloor(HttpServletRequest httpServletRequest) {
        boolean publish = true;
        HttpSession httpSession = httpServletRequest.getSession();
        Floor floor = (Floor) httpSession.getAttribute("floor");
        if (publish) {
            if (floor == null)
                return false;
            floorService.addFloor(floor);
            Set<Table> tableList = floor.getTables();
            tableService.addAllTables(tableList);

            for (Table t : tableList) {
                Set<Desk> temp = t.getDesks();
                deskService.addAllDesk(temp);
            }

            httpSession.removeAttribute("floor");
            return true;
        }
        return false;
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "parse")
    public String parsing(HttpServletRequest request) throws JsonProcessingException {

        FloorObjects parsingData = excelParser.parseFloorDetails("F:\\testBook.xls");
        System.out.println(" Desk list size " + parsingData.getDeskList().size());
        List<Table> tableList = tableGenerator.DFS_UTIL(parsingData);
        parsingData.updateFloor(locationService.getLocationById(1), "2", new HashSet(tableList));
        Floor floor = parsingData.getFloor();
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("floor", floor);
        SimpleBeanPropertyFilter theFilter = SimpleBeanPropertyFilter.serializeAllExcept("location");
        FilterProvider filters = new SimpleFilterProvider().addFilter("floorFilter", theFilter);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writer(filters).writeValueAsString(floor);
    }


}
