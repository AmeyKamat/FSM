package fsm.service;

import fsm.domain.Floor;
import fsm.domain.UI.UploadInfo;
import org.springframework.stereotype.Service;

import java.util.List;

public interface FloorService {

	public Integer addFloor(Floor floor);

	public void removeFloor(int floorId);

	public void updateFloor(Floor floor);

	public Floor getFloorById(int floorId);

	public List<Floor> getAllFloors();

	public Floor parseInformation(int locationId, String floorCode, String path);

	public Floor storeFile(UploadInfo uploadInfo);
}
