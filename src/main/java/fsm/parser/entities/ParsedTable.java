package fsm.parser.entities;

import fsm.model.domain.Floor;
import fsm.model.domain.Table;

public class ParsedTable extends Table {

	public ParsedTable() {
		super();
	}
	
	public ParsedTable(int topLeftX, int topLeftY, int width, int length, Floor floor) {
		super(topLeftX, topLeftY, width, length, floor);
	}

	public Table getTable(){
		return this;
	}
}
