package fsm.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import fsm.dao.FloorDao;
import fsm.domain.Floor;

public class FloorDaoImpl implements FloorDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Integer add(Floor floor) {

		Session session = sessionFactory.getCurrentSession();
		Integer floorID = (Integer) session.save(floor);
		return floorID;

	}

	public void remove(int id) {

		Session session = sessionFactory.getCurrentSession();
		Floor floor = get(id);

		if (floor != null) {
			session.delete(floor);
		}

	}

	public void update(Floor floor) {

		Session session = sessionFactory.getCurrentSession();
		session.update(floor);

	}

	public Floor get(int id) {

		Session session = sessionFactory.getCurrentSession();
		Floor floor = (Floor) session.get(Floor.class, id);
		return floor;

	}

	public List<Floor> getAll() {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Floor.class);
		return criteria.list();

	}

}
