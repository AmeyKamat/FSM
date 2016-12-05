package fsm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/dummyLogout")
public class MyIndexController {

    @RequestMapping(method = RequestMethod.GET)
    public String showLogoutPage(ModelMap map) {

        return "dummyLogout.html";
    }

}
