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


    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView showLoginPage() {
        return new ModelAndView("login.html");
    }


    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView login(final HttpServletRequest req, ModelMap map) {

        /* Commented for integrating backend to frontend. Consequently to be uncommented */
        /*
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String result = userService.checkLogin(username, password);

        if (result == null) {
            System.out.println("Exited here 1");
            return new ModelAndView("redirect:/controller/login");
        } else {
            if (result.equals("EQUAL")) {

                HttpSession session = req.getSession();
                session.setAttribute("id", username);
                System.out.println("Exited here 2");
                return new ModelAndView("redirect:/controller/uploadFile");
            } else {
                System.out.println("Exited here 3");
                return new ModelAndView("redirect:/controller/login");
            }
        }*/
        return new ModelAndView("index.html");

    }

}
