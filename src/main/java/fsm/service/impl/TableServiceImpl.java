package fsm.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fsm.dao.TableDao;
import fsm.model.domain.Table;
import fsm.service.TableService;

@Service
public class TableServiceImpl implements TableService {

    @Autowired
    private TableDao tableDao;

    public Integer addTable(Table table) {
        return tableDao.addTable(table);
    }

    @Override
    @Transactional
    public void addAllTables(Collection<Table> tables) {
        tableDao.addAllTables(tables);
    }

    @Override
    @Transactional
    public void removeTable(int tableId) {
    	tableDao.removeTable(tableId);
    }

    @Override
    @Transactional
    public void updateTable(Table table) {
    	tableDao.updateTable(table);
    }

    @Override
    @Transactional
    public Table getTableById(int tableId) {
        return tableDao.getTableById(tableId);
    }

    @Override
    @Transactional
    public List<Table> getAllTables() {
        return tableDao.getAllTables();
    }

}
