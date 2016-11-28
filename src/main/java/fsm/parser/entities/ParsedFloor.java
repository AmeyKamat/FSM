package fsm.parser.entities;

import fsm.model.domain.Floor;

public class ParsedFloor extends Floor {

	public ParsedFloor(int minX,int minY, int maxX, int maxY){
		super(minX, minY, maxX, maxY);
	}
	
	public Floor getFloor(){
		return this;
	}
}
