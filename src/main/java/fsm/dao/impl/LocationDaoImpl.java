package fsm.dao.impl;

import java.util.List;

import fsm.domain.City;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import fsm.dao.LocationDao;
import fsm.domain.Location;
import org.springframework.stereotype.Repository;

@Repository
public class LocationDaoImpl implements LocationDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Integer addLocation(Location location) {

		Session session = sessionFactory.getCurrentSession();
		Integer locationID = (Integer) session.save(location);
		return locationID;

	}

	public void removeLocation(int locationId) {

		Session session = sessionFactory.getCurrentSession();
		Location location = getLocationById(locationId);

		if (location != null) {
			session.delete(location);
		}

	}

	public void updateLocation(Location location) {

		Session session = sessionFactory.getCurrentSession();
		session.update(location);

	}

	public Location getLocationById(int locationId) {

		Session session = sessionFactory.getCurrentSession();
		Location location = (Location) session.get(Location.class, locationId);
		return location;

	}


	public Location getLocationByName(String locationName) {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(Location.class);
		criteria.add(Restrictions.eq("name", locationName));
		Location location=(Location) criteria.uniqueResult();
		return location;
	}


	public List<Location> getAllLocations() {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Location.class);
		return criteria.list();

	}

	@Override
	public List<Location> getAllLocations(City city) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Location.class);
		criteria.add(Restrictions.eq("city",city));
		return criteria.list();
	}

}
