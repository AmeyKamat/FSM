package fsm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import fsm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/login")
public class LoginController {


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView showLoginPage() {

        return new ModelAndView("login.html");

    }
    
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView authenticateAndLogin() {

        return new ModelAndView("dummyLogout.html");

    }

}
