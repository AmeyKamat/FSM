package fsm.service.middleLayer.impl;

import fsm.dao.TableDao;
import fsm.domain.Table;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TableServiceImpl implements TableDao {

	@Autowired
	private TableDao dao;
	public Integer addTable(Table table) {
return dao.addTable(table);

	}

	public void removeTable(int tableId) {
dao.removeTable(tableId);

	}

	public void updateTable(Table table) {
dao.updateTable(table);
	}

	public Table getTableById(int tableId) {
return dao.getTableById(tableId);

	}

	public List<Table> getAllTables() {
return dao.getAllTables();
	}

}
