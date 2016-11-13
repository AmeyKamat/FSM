package fsm.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import fsm.dao.CityDao;
import fsm.domain.City;

public class CityDaoImpl implements CityDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Integer add(City city) {

		Session session = sessionFactory.getCurrentSession();
		Integer cityID = (Integer) session.save(city);
		return cityID;

	}

	public void remove(int id) {

		Session session = sessionFactory.getCurrentSession();
		City city = get(id);

		if (city != null) {
			session.delete(city);
		}

	}

	public void update(City city) {

		Session session = sessionFactory.getCurrentSession();
		session.update(city);

	}

	public City get(int id) {

		Session session = sessionFactory.getCurrentSession();
		City city = (City) session.get(City.class, id);
		return city;

	}

	public List<City> getAll() {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(City.class);
		return criteria.list();

	}

}
