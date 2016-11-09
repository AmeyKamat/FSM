package fsm.controller.servlets;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fsm.domain.Desk;
import fsm.domain.LayoutData;
import fsm.domain.LayoutExtremes;
import fsm.domain.OfficeDetails;
import fsm.domain.TableData;
import fsm.dao.DataLoader;
import fsm.service.impl.ExcelParser;
import fsm.service.impl.TableGenerator;
import fsm.util.PropertiesUtil;

/**
 * Created by Sarthak on 13-09-2016.
 */

@Controller
public class FileHandlerController {

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public String handleFiles(HttpServletRequest request) {

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
						String country = request.getParameter("country");
						String city = request.getParameter("city");
						String branch = request.getParameter("branch");
						String floor = request.getParameter("floor");
						if (country == null)
							country = "India";
						if (city == null)
							city = "Pune";
						if (branch == null)
							branch = "Kharadi";
						if (floor == null)
							floor = "3";

						DataLoader dataLoader = new DataLoader();
						String locationId = "";
						OfficeDetails officeDetails = dataLoader.getOfficeDetails(country, city, branch, floor);
						locationId = officeDetails.getOfficeUid() + "";
						if (officeDetails != null)
							dataLoader.deleteData(locationId);
						officeDetails = new OfficeDetails(country, city, branch, floor);
						dataLoader.saveOfficeDetails(officeDetails);
						officeDetails = dataLoader.getOfficeDetails(country, city, branch, floor);
						if (fileName.lastIndexOf("\\") != -1) {
							fileName = fileName.substring(fileName.lastIndexOf("\\"));
						}
						String path = filePath + fileName;
						locationId = officeDetails.getOfficeUid() + "";
						ExcelParser excelParser = new ExcelParser();
						LayoutData layoutData = excelParser.getDesk(path, locationId);
						List<Desk> obtaineddesk = layoutData.getDesks();
						LayoutExtremes layoutExtremes = layoutData.getLayoutExtremes();
						TableGenerator tableGenerator = new TableGenerator();
						List<TableData> tableList = tableGenerator.generateTables(layoutData, locationId);
						dataLoader.saveDesk(obtaineddesk);
						dataLoader.saveExtremes(layoutExtremes);
						dataLoader.saveTableData(tableList);

					}
				}

				return "index2.html";

			} catch (Exception ex) {

				return "upload-error.html";

			}
		} else {

			return "upload-no-file.html";

		}
	}

}
