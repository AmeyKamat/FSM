package fsm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, @RequestParam(value = "error", required = false) String error,
						@RequestParam(value = "logout", required = false) String logout, Model model) {

		if (error != null) {
			model.addAttribute("errorMessage", "Invalid username and password !!!");
		}

		if (logout != null) {
			model.addAttribute("logoutMessage", "You've been logged out successfully !!!");
		}
		
		return "login";
	}
	
}