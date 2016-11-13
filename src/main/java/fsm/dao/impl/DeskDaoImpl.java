package fsm.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import fsm.dao.DeskDao;
import fsm.domain.Desk;

public class DeskDaoImpl implements DeskDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Integer add(Desk desk) {

		Session session = sessionFactory.getCurrentSession();
		Integer deskID = (Integer) session.save(desk);
		return deskID;

	}

	public void remove(int id) {

		Session session = sessionFactory.getCurrentSession();
		Desk desk = get(id);

		if (desk != null) {
			session.delete(desk);
		}

	}

	public void update(Desk desk) {

		Session session = sessionFactory.getCurrentSession();
		session.update(desk);

	}

	public Desk get(int id) {

		Session session = sessionFactory.getCurrentSession();
		Desk desk = (Desk) session.get(Desk.class, id);
		return desk;

	}

	public List<Desk> getAll() {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Desk.class);
		return criteria.list();

	}

}
