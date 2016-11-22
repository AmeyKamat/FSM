package fsm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import fsm.service.*;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/uploadFile")
public class FileHandlerController {


    @Autowired
    FloorService floorService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showUploadFilePage() {

        return new ModelAndView("index1.jsp");

    }

}
