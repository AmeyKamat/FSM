package fsm.model.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonRootName;


@Entity
@javax.persistence.Table(name="FLOOR")
@JsonRootName(value = "Floor")
@JsonFilter(value = "filter")
public class Floor {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "location_id")
	private Location location;
	
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

	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "floor")
	private List<Table> tables;

	public Floor() {
		super();
	}


	public Floor(int minX,int minY, int maxX, int maxY){
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

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
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

	public List<Table> getTables() {
		return tables;
	}

	public void setTables(List<Table> tables) {
		this.tables = tables;
	}

}

