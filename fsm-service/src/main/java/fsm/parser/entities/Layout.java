package fsm.parser.entities;

import java.util.List;

public class Layout {
	private ParsedFloor floor;
	private List<ParsedTable> tables;
	private List<ParsedDesk> desks;
	
	public Layout() {}

	public Layout(ParsedFloor floor, List<ParsedTable> tables, List<ParsedDesk> desks) {
		super();
		this.floor = floor;
		this.tables = tables;
		this.desks = desks;
	}

	public ParsedFloor getFloor() {
		return floor;
	}

	public void setFloor(ParsedFloor floor) {
		this.floor = floor;
	}

	public List<ParsedTable> getTables() {
		return tables;
	}

	public void setTables(List<ParsedTable> tables) {
		this.tables = tables;
	}

	public List<ParsedDesk> getDesks() {
		return desks;
	}

	public void setDesks(List<ParsedDesk> desks) {
		this.desks = desks;
	}
	
}
