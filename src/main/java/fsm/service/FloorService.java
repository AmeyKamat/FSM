package fsm.service;

import fsm.domain.Floor;
import fsm.domain.UI.UploadInfo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface FloorService {

	public Integer addFloor(Floor floor);

	public void removeFloor(int floorId);

	public void updateFloor(Floor floor);

	public Floor getFloorById(int floorId);

	public List<Floor> getAllFloors();

	public void parseInformation(int locationId,String floorCode,String path);

	public void storeFile(UploadInfo uploadInfo);
}
