package fsm.service.impl;

import fsm.dao.RoleDao;
import fsm.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoleServiceImpl implements RoleDao {

	@Autowired
	private RoleDao dao;
	public Integer addRole(Role role) {
return dao.addRole(role);

	}

	public void removeRole(int roleId) {
		dao.removeRole(roleId);
	}

	public void updateRole(Role role) {
		dao.updateRole(role);
	}

	public Role getRoleById(int roleId) {
return dao.getRoleById(roleId);
	}

	public List<Role> getAllRoles() {
return dao.getAllRoles();
	}

}
