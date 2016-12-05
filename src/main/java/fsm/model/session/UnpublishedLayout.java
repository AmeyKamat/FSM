package fsm.model.session;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import fsm.model.domain.Floor;

@Component
@Scope("session")
public class UnpublishedLayout {

	private Floor floor;
	private int floorId;

	public UnpublishedLayout() {
		super();
	}

	public UnpublishedLayout(Floor floor, int floorId) {
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
