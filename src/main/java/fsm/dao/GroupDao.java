package fsm.dao;

import java.util.List;

import fsm.domain.Group;

public interface GroupDao {

	public void add(Group group);

	public void remove(int id);

	public void update(Group group);

	public void get(int id);

	public List<Group> getAll();
	
}
