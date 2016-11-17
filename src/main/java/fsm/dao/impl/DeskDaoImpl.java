package fsm.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import fsm.dao.DeskDao;
import fsm.domain.Desk;
import org.springframework.stereotype.Repository;

@Repository
public class DeskDaoImpl implements DeskDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Integer addDesk(Desk desk) {

		Session session = sessionFactory.getCurrentSession();
		Integer deskID = (Integer) session.save(desk);
		return deskID;

	}

	public void removeDesk(int deskId) {

		Session session = sessionFactory.getCurrentSession();
		Desk desk = getDeskById(deskId);

		if (desk != null) {
			session.delete(desk);
		}

	}

	public void updateDesk(Desk desk) {

		Session session = sessionFactory.getCurrentSession();
		session.update(desk);

	}

	public Desk getDeskById(int deskId) {

		Session session = sessionFactory.getCurrentSession();
		Desk desk = (Desk) session.get(Desk.class, deskId);
		return desk;

	}

	public List<Desk> getAllDesks() {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Desk.class);
		return criteria.list();

	}

	public Integer addAllDesk(List<Desk> deskList) {
		Session session = sessionFactory.getCurrentSession();

		 for(Desk desk:deskList)
			   session.save(desk);

		return 1;
	}

}
