package fsm.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fsm.dao.GroupDao;
import fsm.model.domain.Group;

@Repository
public class GroupDaoImpl implements GroupDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Integer addGroup(Group group) {

		Session session = sessionFactory.getCurrentSession();
		Integer groupID = (Integer) session.save(group);
		return groupID;

	}

	@Override
	public void removeGroup(int groupId) {

		Session session = sessionFactory.getCurrentSession();
		Group group = getGroupById(groupId);

		if (group != null) {
			session.delete(group);
		}

	}

	@Override
	public void updateGroup(Group group) {

		Session session = sessionFactory.getCurrentSession();
		session.update(group);

	}

	@Override
	public Group getGroupById(int groupId) {

		Session session = sessionFactory.getCurrentSession();
		Group group = (Group) session.get(Group.class, groupId);
		return group;

	}

	@Override
	public List<Group> getAllGroups() {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Group.class);
		return criteria.list();

	}

}
