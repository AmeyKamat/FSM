package fsm.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import fsm.dao.LocationDao;
import fsm.domain.Location;

public class LocationDaoImpl implements LocationDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Integer add(Location location) {

		Session session = sessionFactory.getCurrentSession();
		Integer locationID = (Integer) session.save(location);
		return locationID;

	}

	public void remove(int id) {

		Session session = sessionFactory.getCurrentSession();
		Location location = get(id);

		if (location != null) {
			session.delete(location);
		}

	}

	public void update(Location location) {

		Session session = sessionFactory.getCurrentSession();
		session.update(location);

	}

	public Location get(int id) {

		Session session = sessionFactory.getCurrentSession();
		Location location = (Location) session.get(Location.class, id);
		return location;

	}

	public List<Location> getAll() {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Location.class);
		return criteria.list();

	}

}
