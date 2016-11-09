package fsm.controller.servlets;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/getMsg")
public class HelloController {

	
	@RequestMapping(method=RequestMethod.GET)
//	@ResponseBody
	public String getMessage(ModelMap map){
		
		System.out.println("came here");
		map.addAttribute("message", "reached here");
		return "displayMessage.jsp";
		
	}
	
	
	
}
