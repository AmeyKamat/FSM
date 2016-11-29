package fsm.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fsm.dao.RoleDao;
import fsm.model.domain.Role;

@Repository
public class RoleDaoImpl implements RoleDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Integer addRole(Role role) {

		Session session = sessionFactory.getCurrentSession();
		Integer roleID = (Integer) session.save(role);
		return roleID;

	}

	@Override
	public void removeRole(int roleId) {

		Session session = sessionFactory.getCurrentSession();
		Role role = getRoleById(roleId);

		if (role != null) {
			session.delete(role);
		}

	}

	@Override
	public void updateRole(Role role) {

		Session session = sessionFactory.getCurrentSession();
		session.update(role);

	}

	@Override
	public Role getRoleById(int roleId) {

		Session session = sessionFactory.getCurrentSession();
		Role role = (Role) session.get(Role.class, roleId);
		return role;

	}

	@Override
	public List<Role> getAllRoles() {

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Role.class);
		return criteria.list();

	}

}
