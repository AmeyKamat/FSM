package fsm.service.impl;

import fsm.dao.FloorDao;
import fsm.domain.Floor;
import fsm.domain.Location;
import fsm.domain.Table;
import fsm.domain.UI.FloorObjects;
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

    @Transactional
    public List<Floor> getAllFloors(int locationId) {
        Location location = locationService.getLocationById(locationId);
        return dao.getAllFloors(location);
    }


}


