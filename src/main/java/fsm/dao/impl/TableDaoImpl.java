package fsm.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import fsm.dao.TableDao;
import fsm.domain.Table;

public class TableDaoImpl implements TableDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Integer addTable(Table table) {

		Session session = sessionFactory.getCurrentSession();
		Integer tableID = (Integer) session.save(table);
		return tableID;

	}

	public void removeTable(int tableId) {

		Session session = sessionFactory.getCurrentSession();
		Table table = getTableById(tableId);

		if (table != null) {
			session.delete(table);
		}

	}

	public void updateTable(Table table) {

		Session session = sessionFactory.getCurrentSession();
		session.update(table);

	}

	public Table getTableById(int tableId) {

		Session session = sessionFactory.getCurrentSession();
		Table table = (Table) session.get(Table.class, tableId);
		return table;

	}

	public List<Table> getAllTables() {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Table.class);
		return criteria.list();

	}

}
