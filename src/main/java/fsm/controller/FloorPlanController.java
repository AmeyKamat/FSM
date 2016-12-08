package fsm.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FloorPlanController {

	@RequestMapping(value = "/floorPlan**", method = RequestMethod.GET)
	public String adminPage(HttpServletRequest request, Model model) {
		if (!(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken)) {
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String name = user.getUsername();
			
			model.addAttribute("username", name);
		}
		
		model.addAttribute("message", "Admin Page (Through Model)");
		
		return "index";
	}
}