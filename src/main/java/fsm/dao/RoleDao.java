package fsm.dao;

import java.util.List;

import fsm.domain.Role;

public interface RoleDao {

	public Integer add(Role role);

	public void remove(int id);

	public void update(Role role);

	public Role get(int id);

	public List<Role> getAll();
	
}
