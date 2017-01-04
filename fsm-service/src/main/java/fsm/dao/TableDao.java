package fsm.dao;

import fsm.model.domain.Table;

import java.util.Collection;
import java.util.List;

public interface TableDao {

	public Integer addTable(Table table);

	public void removeTable(int tableId);

	public void updateTable(Table table);

	public Table getTableById(int tableId);

	public List<Table> getAllTables();

	void addAllTables(Collection<Table> tables);
}
