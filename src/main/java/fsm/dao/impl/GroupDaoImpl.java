package fsm.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import fsm.dao.GroupDao;
import fsm.domain.Group;

public class GroupDaoImpl implements GroupDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Integer add(Group group) {

		Session session = sessionFactory.getCurrentSession();
		Integer groupID = (Integer) session.save(group);
		return groupID;

	}

	public void remove(int id) {

		Session session = sessionFactory.getCurrentSession();
		Group group = get(id);

		if (group != null) {
			session.delete(group);
		}

	}

	public void update(Group group) {

		Session session = sessionFactory.getCurrentSession();
		session.update(group);

	}

	public Group get(int id) {

		Session session = sessionFactory.getCurrentSession();
		Group group = (Group) session.get(Group.class, id);
		return group;

	}

	public List<Group> getAll() {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Group.class);
		return criteria.list();

	}

}
