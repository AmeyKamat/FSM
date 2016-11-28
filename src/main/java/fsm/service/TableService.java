package fsm.service;

import java.util.Collection;
import java.util.List;

import fsm.model.domain.Table;

public interface TableService {

	public Integer addTable(Table table);

	public void addAllTables(Collection<Table> tables);

	public void removeTable(int tableId);

	public void updateTable(Table table);

	public Table getTableById(int tableId);

	public List<Table> getAllTables();

}
