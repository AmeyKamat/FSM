package fsm.controller.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fsm.entity.LayoutExtremes;
import fsm.entity.Location;
import fsm.entity.TableData;
import fsm.repository.impl.DataLoader;

/**
 * Created by Sarthak on 14-09-2016.
 */
@Path("/datafetch")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class DataFetchService {

	@GET
	@Path("/getlayout")
	public LayoutExtremes getLayoutInfo() {
		// Gson gson=new Gson();

		DataLoader dataLoader = new DataLoader();
		LayoutExtremes layoutExtremes = dataLoader.getLayoutExtremes();
		List<TableData> table = dataLoader.getTableData();
		layoutExtremes.tableList = table;
		// String jsonArray=gson.toJson(layoutExtremes);
		// return
		// Response.ok(layoutExtremes).header("Access-Control-Allow-Origin",
		// "*").build();
		return layoutExtremes;
	}

	@POST
	@Path("/getlayout")
	public LayoutExtremes getLayout(Location location) {
		// System.out.println("rest
		// input="+location.getCountry()+location.getCity()+location.getBranch()+location.getFloor());
		DataLoader dataLoader = new DataLoader();
		LayoutExtremes layoutExtremes = dataLoader.getLayoutExtremes(location.getCountry(), location.getCity(),
				location.getBranch(), location.getFloor());
		if (layoutExtremes == null)
			layoutExtremes = new LayoutExtremes();

		List<TableData> table = dataLoader.getTableData(location.getCountry(), location.getCity(), location.getBranch(),
				location.getFloor());
		if (table != null)
			layoutExtremes.tableList = table;

		return layoutExtremes;
	}

	/*
	 * @GET
	 * 
	 * @Path("/gettable") public List<TableData> getTableInfo(){ // Gson
	 * gson=new Gson(); DataLoader dataLoader=new DataLoader(); List<TableData>
	 * tableList=dataLoader.getTableData(); // String
	 * jsonArray=gson.toJson(tableList); // return
	 * Response.ok(jsonArray).header("Access-Control-Allow-Origin",
	 * "*").build(); return tableList; }
	 */
}
