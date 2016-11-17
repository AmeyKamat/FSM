package fsm.service;

import fsm.domain.Table;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TableService {

	public Integer addTable(Table table);

	public Integer addAllTables(List<Table> table);

	public void removeTable(int tableId);

	public void updateTable(Table table);

	public Table getTableById(int tableId);

	public List<Table> getAllTables();

}
