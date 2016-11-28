package fsm.dao.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import fsm.dao.TableDao;
import fsm.model.domain.Table;

import org.springframework.stereotype.Repository;

@Repository
public class TableDaoImpl implements TableDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Integer addTable(Table table) {

		Session session = sessionFactory.getCurrentSession();
		Integer tableID = (Integer) session.save(table);
		return tableID;

	}

	@Override
	public void removeTable(int tableId) {

		Session session = sessionFactory.getCurrentSession();
		Table table = getTableById(tableId);

		if (table != null) {
			session.delete(table);
		}

	}

	@Override
	public void updateTable(Table table) {

		Session session = sessionFactory.getCurrentSession();
		session.update(table);

	}

	@Override
	public Table getTableById(int tableId) {

		Session session = sessionFactory.getCurrentSession();
		Table table = (Table) session.get(Table.class, tableId);
		return table;

	}

	@Override
	public List<Table> getAllTables() {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Table.class);
		return criteria.list();

	}

	@Override
	public void addAllTables(Collection<Table> tables) {
		Session session = sessionFactory.getCurrentSession();

		for(Table table: tables)
		{
			session.save(table);
		}

	}

}
