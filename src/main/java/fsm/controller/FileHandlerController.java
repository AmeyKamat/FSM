package fsm.controller;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import fsm.domain.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import fsm.service.*;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fsm.service.impl.ExcelParser;
import fsm.service.impl.TableGenerator;
import fsm.util.PropertiesUtil;

@Controller
@RequestMapping("/uploadFile")
public class FileHandlerController {


//	@Autowired
//	CountryService daoCountry;

//	@Autowired
//	CityService daoCity;

	@Autowired
	LocationService serviceLocation;

	@Autowired
	FloorService serviceFloor;

	@Autowired
	TableService serviceTable;

	@Autowired
	DeskService serviceDesk;


	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showUploadFilePage() {
		
		return new ModelAndView("index1.jsp");
		
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView handleFiles(HttpServletRequest request) {

		//accept floorCode and locationId

		File file;
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
				Iterator i = fileItems.iterator();
				while (i.hasNext()) {
					FileItem fi = (FileItem) i.next();
					if (!fi.isFormField()) {
						// Get the uploaded file parameters
						String fieldName = fi.getFieldName();
						String fileName = fi.getName();
						boolean isInMemory = fi.isInMemory();
						long sizeInBytes = fi.getSize();
						// Write the file
						if (fileName.lastIndexOf("\\") >= 0) {
							file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\")));
						} else {
							file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\") + 1));
						}
						fi.write(file);
					//	String country = request.getParameter("country");
					//	String city = request.getParameter("city");
						int locationId = Integer.parseInt(request.getParameter("locationId"));
						String floorCode = request.getParameter("floorCode");

						/*	if (country == null)
							country = "India";
						if (city == null)
							city = "Pune";
					*/	if (locationId == 0)
							locationId = 1;
						if (floorCode == null)
							floorCode = "3";

			//			Country country1=daoCountry.getCountryByName(country);
			//			City city1=daoCity.getCityByName(city);
						Location location1=serviceLocation.getLocationById(locationId);




						if (fileName.lastIndexOf("\\") != -1) {
							fileName = fileName.substring(fileName.lastIndexOf("\\"));
						}

						String path = filePath + fileName;

						//locationId = officeDetails.getOfficeUid() + "";
						ExcelParser excelParser = new ExcelParser();
						Vector parsingData=excelParser.parseFloorDetails(path);
						List<Desk> obtaineddesk=(List<Desk>) parsingData.get(0);
						Floor floor2=(Floor) parsingData.get(1);
						floor2.setLocation(location1);
						floor2.setFloorCode(floorCode);


						TableGenerator tableGenerator = new TableGenerator();
						List<Table> tableList = tableGenerator.generateTables(parsingData);

						serviceFloor.addFloor(floor2);

						serviceTable.addAllTables(tableList);

						for(Table t: tableList){
							List<Desk> temp=t.getDesks();
							serviceDesk.addAllDesk(temp);
						}

					}
				}

				return new ModelAndView("redirect:/controller/floorPlan");

			} catch (Exception ex) {

				// return "upload-error.html";
				return new ModelAndView("redirect:/controller/uploadFile");

			}
		} else {

			// return "upload-no-file.html";
			return new ModelAndView("redirect:/controller/uploadFile");

		}
	}

}
