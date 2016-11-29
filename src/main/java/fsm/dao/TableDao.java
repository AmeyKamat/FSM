package fsm.dao;

import java.util.Collection;
import java.util.List;

import fsm.model.domain.Table;

public interface TableDao {

	public Integer addTable(Table table);

	public void removeTable(int tableId);

	public void updateTable(Table table);

	public Table getTableById(int tableId);

	public List<Table> getAllTables();

	void addAllTables(Collection<Table> tables);
}
