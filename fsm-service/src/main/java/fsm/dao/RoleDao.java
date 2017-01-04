package fsm.dao;

import fsm.model.domain.Role;

import java.util.List;

public interface RoleDao {

	public Integer addRole(Role role);

	public void removeRole(int roleId);

	public void updateRole(Role role);

	public Role getRoleById(int roleId);

	public List<Role> getAllRoles();
	
}
