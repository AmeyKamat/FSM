package fsm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by TUSHAR on 16-09-2016.
 */
@Controller
public class LogoutController{

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	@ResponseBody
    public ModelAndView logout(HttpServletRequest request)
    {
    	HttpSession logoutSession = request.getSession();
        logoutSession.invalidate();
        return new ModelAndView("redirect:/");
    }
    
}
