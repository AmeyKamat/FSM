package fsm.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fsm.dao.FloorDao;
import fsm.model.domain.Floor;
import fsm.model.domain.Location;

@Repository
public class FloorDaoImpl implements FloorDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Integer addFloor(Floor floor) {

		Session session = sessionFactory.getCurrentSession();
		Integer floorID = (Integer) session.save(floor);
		return floorID;

	}

	@Override
	public void removeFloor(int floorId) {

		Session session = sessionFactory.getCurrentSession();
		Floor floor = getFloorById(floorId);

		if (floor != null) {
			session.delete(floor);
		}

	}

	@Override
	public void updateFloor(Floor floor) {

		Session session = sessionFactory.getCurrentSession();
		session.update(floor);

	}

	@Override
	public Floor getFloorById(int floorId) {

		Session session = sessionFactory.getCurrentSession();
		// Floor floor = (Floor) session.get(Floor.class, floorId);
		Criteria criteria = session.createCriteria(Floor.class);
		criteria.add(Restrictions.eq("id", floorId));
		Floor floor = (Floor) criteria.uniqueResult();
		return floor;

	}

	@Override
	public List<Floor> getAllFloors() {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Floor.class);
		return criteria.list();

	}

	@Override
	public List<Floor> getAllFloorsByLocation(Location location) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Floor.class);
		criteria.add(Restrictions.eq("location", location));
		return criteria.list();
	}

}
