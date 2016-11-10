package fsm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/floorPlan")
public class FloorPlanController {

	@RequestMapping(method = RequestMethod.GET)
	// @ResponseBody
	public String showFloorPlanPage(ModelMap map) {

		return "index2.html";
	}

}
