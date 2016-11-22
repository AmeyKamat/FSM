package fsm.service.impl;

import fsm.dao.FloorDao;
import fsm.domain.Desk;
import fsm.domain.Floor;
import fsm.domain.Location;
import fsm.domain.Table;
import fsm.domain.UI.FloorObjects;
import fsm.domain.UI.UploadInfo;
import fsm.service.DeskService;
import fsm.service.FloorService;
import fsm.service.LocationService;
import fsm.service.TableService;
import fsm.util.PropertiesUtil;
import org.apache.commons.fileupload.FileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.*;

@Service
public class FloorServiceImpl implements FloorService {

	@Autowired
	private FloorDao dao;

	@Autowired
	private TableService tableService;

	@Autowired
	private DeskService deskService;

	@Autowired
	private LocationService locationService;

	@Autowired
	private ExcelParser excelParser;

	@Autowired
	private TableGenerator tableGenerator;

    @Autowired
    private ConnectedComponentGraphAlgorithm ccga;

	@Transactional
	public Integer addFloor(Floor floor) {
		return dao.addFloor(floor);
	}

	@Transactional
	public void removeFloor(int floorId) {
		dao.removeFloor(floorId);
	}

	@Transactional
	public void updateFloor(Floor floor) {
		dao.updateFloor(floor);
	}

	@Transactional
	public Floor getFloorById(int floorId) {
		return dao.getFloorById(floorId);
	}

	@Transactional
	public List<Floor> getAllFloors() {
		return dao.getAllFloors();
	}

	@Override
	public Floor parseInformation(int locationId, String floorCode, String path) {

		Location location=locationService.getLocationById(locationId);
		FloorObjects parsingData=excelParser.parseFloorDetails(path);
		List<Table> tableList = ccga.DFS_UTIL(parsingData);

//        List<Table> tableList = tableGenerator.generateTables(parsingData);

	/*	floorService.addFloor(parsingData.getFloor());

		tableService.addAllTables(tableList);

		for(Table t: tableList){
			List<Desk> temp=t.getDesks();
			deskService.addAllDesk(temp);
		}
*/
/*

		for(Table table: tableList){
			List<Desk> deskList=table.getDesks();
			Collections.sort(deskList, (o1, o2) -> {

                if(o1.getTableRow()>o2.getTableRow())
                    return 1;
                else if(o1.getTableRow()==o2.getTableRow())
                    if(o1.getTableCol()>o2.getTableCol())
                        return 1;
                    else
                        return -1;
                else
                    return -1;
            });
	}
*/


		parsingData.updateFloor(location,floorCode,new HashSet(tableList));
		return parsingData.getFloor();
	}

	@Override
	public Floor storeFile(UploadInfo uploadInfo) {
		File file;
		String filePath = PropertiesUtil.readProperty("file-upload");
		Iterator i = uploadInfo.getFileItems().iterator();


		while (i.hasNext()) {
			FileItem fi = (FileItem) i.next();
			if (!fi.isFormField()) {
				// Get the uploaded file parameters
				String fieldName = fi.getFieldName();
				uploadInfo.setFileName(fi.getName());
				boolean isInMemory = fi.isInMemory();
				long sizeInBytes = fi.getSize();
				// Write the file
				if (uploadInfo.getFileName().lastIndexOf("\\") >= 0) {
					file = new File(filePath + uploadInfo.getFileName().substring(uploadInfo.getFileName().lastIndexOf("\\")));
				} else {
					file = new File(filePath + uploadInfo.getFileName().substring(uploadInfo.getFileName().lastIndexOf("\\") + 1));
				}

				try {
					fi.write(file);
				} catch (Exception e) {
					e.printStackTrace();
				}

				if (uploadInfo.getFileName().lastIndexOf("\\") != -1) {
					uploadInfo.setFileName(uploadInfo.getFileName().substring(uploadInfo.getFileName().lastIndexOf("\\")));
				}
			}
		}
		String path = filePath + uploadInfo.getFileName();
		Floor floor=parseInformation(uploadInfo.getLocationId(),uploadInfo.getFloorCode(),path);
		return floor;
	}

	@Override
	public Floor parseInformationForTesting(String path) {

		FloorObjects parsingData=excelParser.parseFloorDetails(path);
        System.out.println(" Desk list size "+parsingData.getDeskList().size());
		List<Table> tableList = ccga.DFS_UTIL(parsingData);

		/*for(Table table: tableList){
			List<Desk> deskList=table.getDesks();
			Collections.sort(deskList, (o1, o2) -> {

                if(o1.getTableRow()>o2.getTableRow())
                    return 1;
                else if(o1.getTableRow()==o2.getTableRow())
                    if(o1.getTableCol()>o2.getTableCol())
                        return 1;
                    else
                        return -1;
                else
                    return -1;
            });
		}
*/
		parsingData.updateFloor(locationService.getLocationById(1),"4",new HashSet(tableList));
		return  parsingData.getFloor();

	}


}


