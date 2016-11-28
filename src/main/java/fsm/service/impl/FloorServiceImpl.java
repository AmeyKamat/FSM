package fsm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fsm.dao.FloorDao;
import fsm.model.domain.Floor;
import fsm.model.domain.Location;
import fsm.service.FloorService;

@Service
public class FloorServiceImpl implements FloorService {

    @Autowired
    private FloorDao floorDao;

    @Transactional
    public Integer addFloor(Floor floor) {
        return floorDao.addFloor(floor);
    }

    @Override
    @Transactional
    public void removeFloor(int floorId) {
    	floorDao.removeFloor(floorId);
    }

    @Override
    @Transactional
    public void updateFloor(Floor floor) {
    	floorDao.updateFloor(floor);
    }

    @Override
    @Transactional
    public Floor getFloorById(int floorId) {
        return floorDao.getFloorById(floorId);
    }

    @Override
    @Transactional
    public List<Floor> getAllFloors() {
        return floorDao.getAllFloors();
    }

    @Override
    @Transactional
    public List<Floor> getAllFloorsByLocation(Location location) {
        return floorDao.getAllFloorsByLocation(location);
    }


}


