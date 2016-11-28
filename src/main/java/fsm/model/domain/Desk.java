package fsm.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@javax.persistence.Table(name="DESK")
@JsonIgnoreProperties({"table"})
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
	
	public Desk(){
		super();
	}

	public Desk(String deskCode, Table table, int tableRow, int tableCol, Employee deskEmployee) {
		super();
		this.deskCode = deskCode;
		this.table = table;
		this.tableRow = tableRow;
		this.tableCol = tableCol;
		this.deskEmployee = deskEmployee;
	}
	
	public Desk(String deskCode, Table table, int tableRow, int tableCol) {
		super();
		this.deskCode = deskCode;
		this.table = table;
		this.tableRow = tableRow;
		this.tableCol = tableCol;
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
