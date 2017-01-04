package fsm.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RootController {

	@RequestMapping(value = {"index", "/*"}, method = RequestMethod.GET)
	public String adminPage(HttpServletRequest request, Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String name = user.getUsername();

		model.addAttribute("username", name);
		
		return "index";
	}
}