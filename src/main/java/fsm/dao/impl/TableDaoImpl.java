package fsm.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import fsm.dao.TableDao;
import fsm.domain.Table;
import org.springframework.stereotype.Repository;

@Repository
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

	public Set<Table> getAllTables() {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Table.class);
		return new HashSet(criteria.list());

	}


	public Integer addAllTables(Set<Table> tableList) {
		Session session = sessionFactory.getCurrentSession();

		for(Table tableItem: tableList)
		{
			session.save(tableItem);
		}

		return 1;
	}

}
