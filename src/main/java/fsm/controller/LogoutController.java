package fsm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView logout(HttpServletRequest request) {
        HttpSession logoutSession = request.getSession();
        logoutSession.invalidate();
        return new ModelAndView("redirect:/controller/login");
    }

}
