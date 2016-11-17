package fsm.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import fsm.dao.CityDao;
import fsm.domain.City;
import org.springframework.stereotype.Repository;

@Repository
public class CityDaoImpl implements CityDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Integer addCity(City city) {

		Session session = sessionFactory.getCurrentSession();
		Integer cityID = (Integer) session.save(city);
		return cityID;

	}

	public void removeCity(int cityId) {

		Session session = sessionFactory.getCurrentSession();
		City city = getCityById(cityId);

		if (city != null) {
			session.delete(city);
		}

	}

	public void updateCity(City city) {

		Session session = sessionFactory.getCurrentSession();
		session.update(city);

	}

	public City getCityById(int cityId) {

		Session session = sessionFactory.getCurrentSession();
		City city = (City) session.get(City.class, cityId);
		return city;

	}
	public City getCityByName(String cityName)
	{
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria=session.createCriteria(City.class);
		criteria.add(Restrictions.eq("name", cityName));
		City city=(City)criteria.uniqueResult();
		return city;
	}
	public List<City> getAllCities() {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(City.class);
		return criteria.list();

	}

}
