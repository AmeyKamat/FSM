package fsm.dao.impl;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fsm.dao.DeskDao;
import fsm.model.domain.Desk;

@Repository
public class DeskDaoImpl implements DeskDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Integer addDesk(Desk desk) {

		Session session = sessionFactory.getCurrentSession();
		Integer deskID = (Integer) session.save(desk);
		return deskID;

	}

	@Override
	public void removeDesk(int deskId) {

		Session session = sessionFactory.getCurrentSession();
		Desk desk = getDeskById(deskId);

		if (desk != null) {
			session.delete(desk);
		}

	}

	@Override
	public void updateDesk(Desk desk) {

		Session session = sessionFactory.getCurrentSession();
		session.update(desk);

	}

	@Override
	public Desk getDeskById(int deskId) {

		Session session = sessionFactory.getCurrentSession();
		Desk desk = (Desk) session.get(Desk.class, deskId);
		return desk;

	}

	@Override
	public List<Desk> getAllDesks() {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Desk.class);
		return criteria.list();

	}

	@Override
	public void addAllDesks(Collection<Desk> desks) {
		Session session = sessionFactory.getCurrentSession();

		for (Desk desk : desks)
			session.save(desk);
	}

}
