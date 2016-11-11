package fsm.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Table {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@ManyToOne
	@JoinColumn(name = "floor_id")
	private Floor floor;
	@Column(name = "top_left_x")
	private int topLeftX;
	@Column(name = "top_left_y")
	private int topLeftY;
	@Column(name = "width")
	private int width;
	@Column(name = "length")
	private int length;
	@OneToMany(mappedBy = "table")
	private Set<Desk> desks;

	public Table() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Floor getFloor() {
		return floor;
	}

	public void setFloor(Floor floor) {
		this.floor = floor;
	}

	public int getTopLeftX() {
		return topLeftX;
	}

	public void setTopLeftX(int topLeftX) {
		this.topLeftX = topLeftX;
	}

	public int getTopLeftY() {
		return topLeftY;
	}

	public void setTopLeftY(int topLeftY) {
		this.topLeftY = topLeftY;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public Set<Desk> getDesks() {
		return desks;
	}

	public void setDesks(Set<Desk> desks) {
		this.desks = desks;
	}

}
