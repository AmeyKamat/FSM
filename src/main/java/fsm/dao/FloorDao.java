package fsm.dao;

import java.util.List;

import fsm.model.domain.Floor;
import fsm.model.domain.Location;

public interface FloorDao {

	public Integer addFloor(Floor floor);

	public void removeFloor(int floorId);

	public void updateFloor(Floor floor);

	public Floor getFloorById(int floorId);

	public List<Floor> getAllFloors();

    List<Floor> getAllFloorsByLocation(Location location);
}
