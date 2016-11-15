package fsm.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@javax.persistence.Table(name="DESK")
@JsonIgnoreProperties({"table","deskEmployee","x","y","width","height"})
public class Desk {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "table_id")
	private Table table;

	@OneToOne
	@JoinColumn(name = "employee_id")
	private Employee deskEmployee;
	
	@NotNull
	@Column(name = "table_row")
	private int tableRow;
	
	@NotNull
	@Column(name = "table_col")
	private int tableCol;
	
	@NotNull
	@Column(name = "desk_code")
	private String deskCode;

	@Transient
	private int x,y,width,height;




	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}


	public Desk() {
		super();
	}

	public Desk(String deskCode, int x, int y, int width, int height){
		this.deskCode=deskCode;
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
	}

	public Desk(int x, int y) {
		this.x=x;
		this.y=y;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public Employee getDeskEmployee() {
		return deskEmployee;
	}

	public void setDeskEmployee(Employee deskEmployee) {
		this.deskEmployee = deskEmployee;
	}

	public int getTableRow() {
		return tableRow;
	}

	public void setTableRow(int tableRow) {
		this.tableRow = tableRow;
	}

	public int getTableCol() {
		return tableCol;
	}

	public void setTableCol(int tableCol) {
		this.tableCol = tableCol;
	}

	public String getDeskCode() {
		return deskCode;
	}

	public void setDeskCode(String deskCode) {
		this.deskCode = deskCode;
	}

}
