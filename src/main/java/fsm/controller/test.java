package fsm.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class test {

	@Value("${user.name}")
	private String user_name;
	
	@RequestMapping(value="/home",method=RequestMethod.GET)
    public String getHomePage(Model model){
		System.out.println(user_name);
        model.addAttribute("username", user_name);
        return "home.jsp";
        
    }
}
