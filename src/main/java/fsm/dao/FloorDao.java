package fsm.dao;

import java.util.List;

import fsm.domain.Floor;
import org.springframework.stereotype.Repository;

@Repository
public interface FloorDao {

	public Integer addFloor(Floor floor);

	public void removeFloor(int floorId);

	public void updateFloor(Floor floor);

	public Floor getFloorById(int floorId);

	public List<Floor> getAllFloors();

}
