package fsm.parser.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import fsm.model.domain.Desk;
import fsm.model.domain.Floor;
import fsm.model.domain.Table;

import java.util.LinkedList;
import java.util.List;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
@JsonIgnoreProperties({"table"})
public class ParsedTable extends Table {

	public ParsedTable() {
		super();
		this.setDesks(new LinkedList<Desk>());
	}
	
	public ParsedTable(int topLeftX, int topLeftY, int width, int length, Floor floor) {
		super(topLeftX, topLeftY, width, length, floor);
		this.setDesks(new LinkedList<Desk>());
	}

	public Table getTable(){
		return this;
	}

	public void addDesk(ParsedDesk desk){
		List<Desk> desks = this.getDesks();
		desks.add(desk);
	}
}
