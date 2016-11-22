package fsm.service;

import fsm.domain.Table;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

public interface TableService {

	public Integer addTable(Table table);

	public Integer addAllTables(Set<Table> table);

	public void removeTable(int tableId);

	public void updateTable(Table table);

	public Table getTableById(int tableId);

	public Set<Table> getAllTables();

}
