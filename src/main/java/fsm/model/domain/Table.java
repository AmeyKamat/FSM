package fsm.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.*;

import java.util.List;
import java.util.Set;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.OrderBy;
import javax.validation.constraints.NotNull;

@Entity
@javax.persistence.Table(name = "WORKTABLE")
@JsonIgnoreProperties("floor")
public class Table {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "floor_id")
	private Floor floor;

	@NotNull
	@Column(name = "top_left_x")
	private int topLeftX;

	@NotNull
	@Column(name = "top_left_y")
	private int topLeftY;

	@NotNull
	@Column(name = "width")
	private int width;

	@NotNull
	@Column(name = "length")
	private int length;

	@OrderBy("tableRow,tableCol")
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "table")
	private List<Desk> desks;

	public Table() {
		super();
	}

	public Table(int topLeftX, int topLeftY, int width, int length, Floor floor) {
		super();
		this.topLeftX = topLeftX;
		this.topLeftY = topLeftY;
		this.width = width;
		this.length = length;
		this.floor = floor;
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

	public List<Desk> getDesks() {
		return desks;
	}

	public void setDesks(List<Desk> desks) {
		this.desks = desks;
	}

}
