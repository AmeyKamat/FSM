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

	public Integer addRole(Role role) {

		Session session = sessionFactory.getCurrentSession();
		Integer roleID = (Integer) session.save(role);
		return roleID;

	}

	public void removeRole(int roleId) {

		Session session = sessionFactory.getCurrentSession();
		Role role = getRoleById(roleId);

		if (role != null) {
			session.delete(role);
		}

	}

	public void updateRole(Role role) {

		Session session = sessionFactory.getCurrentSession();
		session.update(role);

	}

	public Role getRoleById(int roleId) {

		Session session = sessionFactory.getCurrentSession();
		Role role = (Role) session.get(Role.class, roleId);
		return role;

	}

	public List<Role> getAllRoles() {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Role.class);
		return criteria.list();

	}

}
