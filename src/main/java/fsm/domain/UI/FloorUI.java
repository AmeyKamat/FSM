package fsm.domain.UI;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;


@Entity
@javax.persistence.Table(name="FLOOR")
@JsonRootName(value = "Floor")
@JsonIgnoreProperties("location")
@JsonFilter("floorFilter")
public class FloorUI {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "location_id")
	private LocationUI location;
	
	@NotNull
	@Column(name = "floor_code")
	private String floorCode;
	
	@NotNull
	@Column(name = "min_x")
	private int minX;
	
	@NotNull
	@Column(name = "min_y")
	private int minY;
	
	@NotNull
	@Column(name = "max_x")
	private int maxX;
	
	@NotNull
	@Column(name = "max_y")
	private int maxY;
	
	@OneToMany(mappedBy = "floor")
	private Set<TableUI> tables;

	public FloorUI() {
		super();
	}


	public FloorUI(int minX, int minY, int maxX, int maxY){
		this.minX=minX;
		this.minY=minY;
		this.maxX=maxX;
		this.maxY=maxY;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocationUI getLocation() {
		return location;
	}

	public void setLocation(LocationUI location) {
		this.location = location;
	}

	public String getFloorCode() {
		return floorCode;
	}

	public void setFloorCode(String floorCode) {
		this.floorCode = floorCode;
	}

	public int getMinX() {
		return minX;
	}

	public void setMinX(int minX) {
		this.minX = minX;
	}

	public int getMinY() {
		return minY;
	}

	public void setMinY(int minY) {
		this.minY = minY;
	}

	public int getMaxX() {
		return maxX;
	}

	public void setMaxX(int maxX) {
		this.maxX = maxX;
	}

	public int getMaxY() {
		return maxY;
	}

	public void setMaxY(int maxY) {
		this.maxY = maxY;
	}

	public Set<TableUI> getTables() {
		return tables;
	}

	public void setTables(Set<TableUI> tables) {
		this.tables = tables;
	}

}
