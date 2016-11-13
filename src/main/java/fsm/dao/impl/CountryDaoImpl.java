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

	public Integer add(Country country) {

		Session session = sessionFactory.getCurrentSession();
		Integer countryID = (Integer) session.save(country);
		return countryID;

	}

	public void remove(int id) {

		Session session = sessionFactory.getCurrentSession();
		Country country = get(id);

		if (country != null) {
			session.delete(country);
		}

	}

	public void update(Country country) {

		Session session = sessionFactory.getCurrentSession();
		session.update(country);

	}

	public Country get(int id) {

		Session session = sessionFactory.getCurrentSession();
		Country country = (Country) session.get(Country.class, id);
		return country;

	}

	public List<Country> getAll() {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Country.class);
		return criteria.list();

	}

}
