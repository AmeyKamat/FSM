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
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView storingFile(HttpServletRequest request) {

		//accept floorCode and locationId
		String fileName=null;

		int maxFileSize = 5000 * 1024;
		int maxMemSize = 5000 * 1024;

		String filePath = PropertiesUtil.readProperty("file-upload");
		System.out.println(filePath);

		// Verify the content type
		String contentType = request.getContentType();

		if ((contentType.indexOf("multipart/form-data") >= 0)) {

			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(maxMemSize);

			// TO DO: Better to pick this up from *.application file
			factory.setRepository(new File(filePath)); // uploading a file to
														// context path
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setSizeMax(maxFileSize);
			try {

				List fileItems = upload.parseRequest(request);
				int locationId=Integer.parseInt(request.getParameter("locationId"));
				String floorCode=request.getParameter("floorCode");
				floorService.storeFile(new UploadInfo(fileItems,fileName,locationId,floorCode));
				return new ModelAndView("redirect:/controller/floorPlan");

			} catch (Exception ex) {
				return new ModelAndView("redirect:/controller/uploadFile");

			}
		} else {

			return new ModelAndView("redirect:/controller/uploadFile");

		}



	}




}
