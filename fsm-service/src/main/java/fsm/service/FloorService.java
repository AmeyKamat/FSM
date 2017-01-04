package fsm.service;

import fsm.model.domain.Floor;
import fsm.model.domain.Location;

import java.util.List;

public interface FloorService {

	public Integer addFloor(Floor floor);

	public void removeFloor(int floorId);

	public void updateFloor(Floor floor);

	public Floor getFloorById(int floorId);

	public List<Floor> getAllFloors();

	public List<Floor> getAllFloorsByLocation(Location location);

}
