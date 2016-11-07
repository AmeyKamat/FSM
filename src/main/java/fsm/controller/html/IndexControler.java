package fsm.controller.html;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/index")
public class IndexControler {
	
	@RequestMapping(method=RequestMethod.GET)
	public String getIndexPage(){
		System.out.println("abc");
		return "index";
	}
}
