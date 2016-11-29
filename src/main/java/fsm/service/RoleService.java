package fsm.service;

import java.util.List;

import fsm.model.domain.Role;

public interface RoleService {

	public Integer addRole(Role role);

	public void removeRole(int roleId);

	public void updateRole(Role role);

	public Role getRoleById(int roleId);

	public List<Role> getAllRoles();
	
}
