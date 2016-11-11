package fsm.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

public class Desk {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@ManyToOne
	@JoinColumn(name = "table_id")
	private Table table;
	@OneToOne
	@JoinColumn(name = "employee_id")
	private Employee deskEmployee;
	@Column(name = "table_row")
	private int tableRow;
	@Column(name = "table_col")
	private int tableCol;
	@Column(name = "desk_code")
	private String deskCode;

	public Desk() {
		super();
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
