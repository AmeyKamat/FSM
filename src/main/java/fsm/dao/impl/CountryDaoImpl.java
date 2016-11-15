package fsm.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import fsm.dao.CountryDao;
import fsm.domain.Country;

public class CountryDaoImpl implements CountryDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Integer addCountry(Country country) {

		Session session = sessionFactory.getCurrentSession();
		Integer countryID = (Integer) session.save(country);
		return countryID;

	}

	public void removeCountry(int countryId) {

		Session session = sessionFactory.getCurrentSession();
		Country country = getCountryById(countryId);

		if (country != null) {
			session.delete(country);
		}

	}

	public void updateCountry(Country country) {

		Session session = sessionFactory.getCurrentSession();
		session.update(country);

	}

	public Country getCountryById(int countryId) {

		Session session = sessionFactory.getCurrentSession();
		Country country = (Country) session.get(Country.class, countryId);
		return country;

	}

	public Country getCountryByName(String countryName) {
		Session session = sessionFactory.getCurrentSession();
		Country country = (Country) session.get(Country.class, countryName);
		return country;
	}
	public List<Country> getAllCountries() {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Country.class);
		return criteria.list();

	}

}
