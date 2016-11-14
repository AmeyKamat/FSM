package fsm.service.middleLayer;

import fsm.domain.Table;

import java.util.List;

public interface TableService {

	public Integer addTable(Table table);

	public void removeTable(int tableId);

	public void updateTable(Table table);

	public Table getTableById(int tableId);

	public List<Table> getAllTables();

}
