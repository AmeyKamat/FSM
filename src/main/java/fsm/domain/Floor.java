package fsm.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Floor {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@ManyToOne
	@JoinColumn(name = "location_id")
	private Location location;
	@Column(name = "floor_code")
	private String floorCode;
	@Column(name = "min_x")
	private int minX;
	@Column(name = "min_y")
	private int minY;
	@Column(name = "max_x")
	private int maxX;
	@Column(name = "max_y")
	private int maxY;
	@OneToMany(mappedBy = "floor")
	private Set<Table> tables;

	public Floor() {
		super();
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

	public Set<Table> getTables() {
		return tables;
	}

	public void setTables(Set<Table> tables) {
		this.tables = tables;
	}

}
