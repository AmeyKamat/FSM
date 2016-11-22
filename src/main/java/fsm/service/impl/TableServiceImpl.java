package fsm.service.impl;

import fsm.dao.TableDao;
import fsm.domain.Table;
import fsm.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class TableServiceImpl implements TableService {

    @Autowired
    private TableDao dao;

    public Integer addTable(Table table) {
        return dao.addTable(table);
    }

    @Transactional
    public Integer addAllTables(Set<Table> table) {
        return dao.addAllTables(table);
    }

    @Transactional
    public void removeTable(int tableId) {
        dao.removeTable(tableId);
    }

    @Transactional
    public void updateTable(Table table) {
        dao.updateTable(table);
    }

    @Transactional
    public Table getTableById(int tableId) {
        return dao.getTableById(tableId);
    }

    @Transactional
    public Set<Table> getAllTables() {
        return dao.getAllTables();
    }

}
