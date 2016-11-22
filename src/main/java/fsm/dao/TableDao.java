package fsm.dao;

import java.util.List;
import java.util.Set;

import fsm.domain.Table;
import org.springframework.stereotype.Repository;

//@Repository
public interface TableDao {

	public Integer addTable(Table table);

	public void removeTable(int tableId);

	public void updateTable(Table table);

	public Table getTableById(int tableId);

	public Set<Table> getAllTables();

    Integer addAllTables(Set<Table> table);
}
