package fsm.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import fsm.dao.GroupDao;
import fsm.domain.Group;
import org.springframework.stereotype.Repository;

@Repository
public class GroupDaoImpl implements GroupDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Integer addGroup(Group group) {

		Session session = sessionFactory.getCurrentSession();
		Integer groupID = (Integer) session.save(group);
		return groupID;

	}

	public void removeGroup(int groupId) {

		Session session = sessionFactory.getCurrentSession();
		Group group = getGroupById(groupId);

		if (group != null) {
			session.delete(group);
		}

	}

	public void updateGroup(Group group) {

		Session session = sessionFactory.getCurrentSession();
		session.update(group);

	}

	public Group getGroupById(int groupId) {

		Session session = sessionFactory.getCurrentSession();
		Group group = (Group) session.get(Group.class, groupId);
		return group;

	}

	public List<Group> getAllGroups() {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Group.class);
		return criteria.list();

	}

}
