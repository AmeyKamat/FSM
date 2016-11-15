package fsm.service.impl;

import fsm.dao.FloorDao;
import fsm.domain.Floor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FloorServiceImpl implements FloorDao {

	@Autowired
	private FloorDao dao;

	public Integer addFloor(Floor floor) {
		return dao.addFloor(floor);
	}

	public void removeFloor(int floorId) {
		dao.removeFloor(floorId);
	}

	public void updateFloor(Floor floor) {
		dao.updateFloor(floor);
	}

	public Floor getFloorById(int floorId) {
		return dao.getFloorById(floorId);
	}

	public List<Floor> getAllFloors() {
		return dao.getAllFloors();
	}

}
