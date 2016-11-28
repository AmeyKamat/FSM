package fsm.model.response;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import fsm.model.domain.Floor;

@Component
@Scope("session")
public class UnpublishedLayoutResponse {

	private Floor floor;
	private int floorId;

	public UnpublishedLayoutResponse() {
		super();
	}

	public UnpublishedLayoutResponse(Floor floor, int floorId) {
		this.floor = floor;
		this.floorId = floorId;
	}

	public Floor getFloor() {
		return floor;
	}

	public void setFloor(Floor floor) {
		this.floor = floor;
	}

	public int getFloorId() {
		return floorId;
	}

	public void setFloorId(int floorId) {
		this.floorId = floorId;
	}
}
