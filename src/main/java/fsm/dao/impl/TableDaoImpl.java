package fsm.dao.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fsm.model.domain.Country;
import fsm.model.domain.Floor;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
	public void removeTablesByFloorId(int floorId) {

		List<Table> tablesOnGivenFloor = getAllTablesByFloorId(floorId);
		System.out.println("Total tables to be deleted: " + tablesOnGivenFloor.size());
		removeAllTables(tablesOnGivenFloor);
		System.out.println("Tables deleted: ");
//		System.out.println("Total tables present now: " + getAllTablesByFloorId(floorId));

	}

	private void removeAllTables(List<Table> tablesToBeDeleted) {
		Session session = sessionFactory.getCurrentSession();
		for (Table table: tablesToBeDeleted) {
			session.delete(table);
		}
	}

	private List<Table> getAllTablesByFloorId(int floorId) {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Table.class);
		criteria.add(Restrictions.eq("floor.id", floorId));
		return criteria.list();

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
