package fsm.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import fsm.domain.UI.UploadInfo;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import fsm.service.*;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fsm.util.PropertiesUtil;

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
