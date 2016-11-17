package fsm.controller.rest;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import javax.jws.WebParam;

import fsm.domain.Desk;
import fsm.domain.Floor;
import fsm.domain.Location;
import fsm.domain.Table;
import fsm.service.CountryService;
import fsm.service.DeskService;
import fsm.service.FloorService;
import fsm.service.TableService;
import fsm.service.impl.ExcelParser;
import fsm.service.impl.TableGenerator;
import jdk.nashorn.api.scripting.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

//@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
@RestController("/parsingInformation")
public class FloorRest {


	@Autowired
	FloorService floorService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Floor getParsingInformation(@PathVariable int floorId) {
		Floor floor=floorService.getFloorById(floorId);
		return floor;
	}






}
