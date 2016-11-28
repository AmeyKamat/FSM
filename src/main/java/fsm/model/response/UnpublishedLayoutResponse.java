package fsm.model.response;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import fsm.model.domain.Floor;

@Component
@Scope("session")
public class UnpublishedLayoutResponse {

	private Floor floor;

	public UnpublishedLayoutResponse() {
		super();
	}

	public UnpublishedLayoutResponse(Floor floor) {
		super();
		this.floor = floor;
	}

	public Floor getFloor() {
		return floor;
	}

	public void setFloor(Floor floor) {
		this.floor = floor;
	}
	
}
