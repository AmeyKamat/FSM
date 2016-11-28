package fsm.service;

import java.util.List;

import fsm.model.domain.Floor;
import fsm.model.domain.Location;

public interface FloorService {

	public Integer addFloor(Floor floor);

	public void removeFloor(int floorId);

	public void updateFloor(Floor floor);

	public Floor getFloorById(int floorId);

	public List<Floor> getAllFloors();

	public List<Floor> getAllFloorsByLocation(Location location);

}
