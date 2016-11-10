package fsm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import fsm.domain.Users;
import fsm.dao.DataLoader;

/**
 * Created by TUSHAR on 15-09-2016.
 */

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView login(final HttpServletRequest req, ModelMap map) {

		System.out.println("Came here");
		String id = req.getParameter("username");
		String password = req.getParameter("password");
		DataLoader dataLoader = new DataLoader();
		Users userCheckLogin = dataLoader.getUser(id);
		
		if (userCheckLogin == null) {

			map.addAttribute("error_message", "User does not exist");
			System.out.println("Exited here 1");
			return new ModelAndView("login.html");

		} 
		else {

			if (password.equals(userCheckLogin.getPassword())) {

				HttpSession session = req.getSession();
				session.setAttribute("id", id);
				// TODO: resp.sendRedirect(req.getContextPath()); // check filename
				System.out.println("Exited here 2");
				return new ModelAndView("index1.jsp");

			}
			else {

				map.addAttribute("error_message", "User does not exist");
				System.out.println("Exited here 3");
				return new ModelAndView("login.html");

			}

		}
		

	}

}
