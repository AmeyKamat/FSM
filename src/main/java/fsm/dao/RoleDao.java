package fsm.dao;

import java.util.List;

import fsm.domain.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao {

	public Integer addRole(Role role);

	public void removeRole(int roleId);

	public void updateRole(Role role);

	public Role getRoleById(int roleId);

	public List<Role> getAllRoles();
	
}
