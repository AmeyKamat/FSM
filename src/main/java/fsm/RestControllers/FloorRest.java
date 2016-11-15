package fsm.RestControllers;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fsm.domain.Floor;
import fsm.domain.Location;
import fsm.service.CountryService;
import fsm.service.DeskService;
import fsm.service.FloorService;
import fsm.service.TableService;
import jdk.nashorn.api.scripting.JSObject;
import org.springframework.beans.factory.annotation.Autowired;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/parsingInformation")
public class FloorRest {


	@Autowired
	FloorService floorService;

	@GET
    public Floor getParsingInformation(int floorId) {
		Floor floor=floorService.getFloorById(floorId);
		return floor;
	}







}
