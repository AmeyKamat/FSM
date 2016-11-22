package fsm.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import fsm.dao.FloorDao;
import fsm.domain.Floor;
import org.springframework.stereotype.Repository;

@Repository
public class FloorDaoImpl implements FloorDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Integer addFloor(Floor floor) {

		Session session = sessionFactory.getCurrentSession();
		Integer floorID = (Integer) session.save(floor);
		return floorID;

	}

	public void removeFloor(int floorId) {

		Session session = sessionFactory.getCurrentSession();
		Floor floor = getFloorById(floorId);

		if (floor != null) {
			session.delete(floor);
		}

	}

	public void updateFloor(Floor floor) {

		Session session = sessionFactory.getCurrentSession();
		session.update(floor);

	}

	public Floor getFloorById(int floorId) {

		Session session = sessionFactory.getCurrentSession();
		//Floor floor = (Floor) session.get(Floor.class, floorId);
		Criteria criteria=session.createCriteria(Floor.class);
		criteria.add(Restrictions.eq("id",floorId));
		Floor floor=(Floor)criteria.uniqueResult();
		return floor;

	}

	public List<Floor> getAllFloors() {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Floor.class);
		return criteria.list();

	}

}
