package fsm.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import fsm.dao.RoleDao;
import fsm.domain.Role;

public class RoleDaoImpl implements RoleDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Integer add(Role role) {

		Session session = sessionFactory.getCurrentSession();
		Integer roleID = (Integer) session.save(role);
		return roleID;

	}

	public void remove(int id) {

		Session session = sessionFactory.getCurrentSession();
		Role role = get(id);

		if (role != null) {
			session.delete(role);
		}

	}

	public void update(Role role) {

		Session session = sessionFactory.getCurrentSession();
		session.update(role);

	}

	public Role get(int id) {

		Session session = sessionFactory.getCurrentSession();
		Role role = (Role) session.get(Role.class, id);
		return role;

	}

	public List<Role> getAll() {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Role.class);
		return criteria.list();

	}

}
