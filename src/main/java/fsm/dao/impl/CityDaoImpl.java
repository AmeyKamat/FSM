package fsm.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fsm.dao.CityDao;
import fsm.model.domain.City;
import fsm.model.domain.Country;

@Repository
public class CityDaoImpl implements CityDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Integer addCity(City city) {

		Session session = sessionFactory.getCurrentSession();
		Integer cityID = (Integer) session.save(city);
		return cityID;

	}

	@Override
	public void removeCity(int cityId) {

		Session session = sessionFactory.getCurrentSession();
		City city = getCityById(cityId);

		if (city != null) {
			session.delete(city);
		}

	}

	@Override
	public void updateCity(City city) {

		Session session = sessionFactory.getCurrentSession();
		session.update(city);

	}

	@Override
	public City getCityById(int cityId) {

		Session session = sessionFactory.getCurrentSession();
		City city = (City) session.get(City.class, cityId);
		return city;

	}

	@Override
	public List<City> getCitiesByName(String cityName) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(City.class);
		criteria.add(Restrictions.eq("name", cityName));
		return criteria.list();
	}

	@Override
	public List<City> getAllCities() {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(City.class);
		return criteria.list();

	}

	@Override
	public List<City> getCitiesByCountry(Country country) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(City.class);
		criteria.add(Restrictions.eq("country", country));
		return criteria.list();
	}

}
