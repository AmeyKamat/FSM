package fsm.dao;

import java.util.List;

import fsm.domain.Table;

public interface TableDao {

	public Integer addTable(Table table);

	public void removeTable(int tableId);

	public void updateTable(Table table);

	public Table getTableById(int tableId);

	public List<Table> getAllTables();

    Integer addAllTables(List<Table> table);
}
