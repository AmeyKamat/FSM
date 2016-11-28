package fsm.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fsm.dao.CountryDao;
import fsm.model.domain.Country;

@Repository
public class CountryDaoImpl implements CountryDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Integer addCountry(Country country) {

		Session session = sessionFactory.getCurrentSession();
		Integer countryID = (Integer) session.save(country);
		return countryID;

	}

	@Override
	public void removeCountry(int countryId) {

		Session session = sessionFactory.getCurrentSession();
		Country country = getCountryById(countryId);

		if (country != null) {
			session.delete(country);
		}

	}

	@Override
	public void updateCountry(Country country) {

		Session session = sessionFactory.getCurrentSession();
		session.update(country);

	}

	@Override
	public Country getCountryById(int countryId) {

		Session session = sessionFactory.getCurrentSession();
		Country country = (Country) session.get(Country.class, countryId);
		return country;

	}

	@Override
	public Country getCountryByName(String countryName) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Country.class);
		criteria.add(Restrictions.eq("name", countryName));
		Country country = (Country) criteria.uniqueResult();
		return country;
	}

	@Override
	public List<Country> getAllCountries() {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Country.class);
		return criteria.list();

	}

}
