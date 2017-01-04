package fsm.parser.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import fsm.model.domain.Floor;
import fsm.model.domain.Table;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.LinkedList;

@Entity
@DiscriminatorValue(value="parsing")
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
@JsonIgnoreProperties({"floor"})
public class ParsedFloor extends Floor {

	public ParsedFloor(int minX,int minY, int maxX, int maxY){

		super(minX, minY, maxX, maxY);
		this.setTables(new LinkedList<Table>());
	}
	
	public Floor getFloor(){
		return this;
	}

	public void addTable(ParsedTable table){
		this.getTables().add(table);
	}
}
