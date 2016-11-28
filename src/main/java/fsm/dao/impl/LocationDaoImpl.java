package fsm.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fsm.dao.LocationDao;
import fsm.model.domain.City;
import fsm.model.domain.Location;

@Repository
public class LocationDaoImpl implements LocationDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Integer addLocation(Location location) {

		Session session = sessionFactory.getCurrentSession();
		Integer locationID = (Integer) session.save(location);
		return locationID;

	}

	@Override
	public void removeLocation(int locationId) {

		Session session = sessionFactory.getCurrentSession();
		Location location = getLocationById(locationId);

		if (location != null) {
			session.delete(location);
		}

	}

	@Override
	public void updateLocation(Location location) {

		Session session = sessionFactory.getCurrentSession();
		session.update(location);

	}

	@Override
	public Location getLocationById(int locationId) {

		Session session = sessionFactory.getCurrentSession();
		Location location = (Location) session.get(Location.class, locationId);
		return location;

	}

	@Override
	public List<Location> getLocationsByName(String locationName) {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Location.class);
		criteria.add(Restrictions.eq("name", locationName));
		return criteria.list();
	}

	@Override
	public List<Location> getAllLocations() {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Location.class);
		return criteria.list();

	}

	@Override
	public List<Location> getAllLocationsByCity(City city) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Location.class);
		criteria.add(Restrictions.eq("city", city));
		return criteria.list();
	}

}
