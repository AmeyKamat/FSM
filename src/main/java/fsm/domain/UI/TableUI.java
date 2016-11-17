package fsm.domain.UI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@javax.persistence.Table(name="TABLE")
@JsonIgnoreProperties("floor")
public class TableUI {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "floor_id")
	private FloorUI floor;
	
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
	
	@OneToMany(mappedBy = "table")
	private List<DeskUI> desks;

	public TableUI() {
		super();
	}

	public TableUI(List<DeskUI> desks, int width, int length, int topLeftX, int topLeftY){
		this.desks=desks;
		this.width=width;
		this.length=length;
		this.topLeftX=topLeftX;
		this.topLeftY=topLeftY;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public FloorUI getFloor() {
		return floor;
	}

	public void setFloor(FloorUI floor) {
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

	public List<DeskUI> getDesks() {
		return desks;
	}

	public void setDesks(List<DeskUI> desks) {
		this.desks = desks;
	}

}
