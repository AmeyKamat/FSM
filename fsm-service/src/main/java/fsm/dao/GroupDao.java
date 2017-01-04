package fsm.dao;

import fsm.model.domain.Group;

import java.util.List;

public interface GroupDao {

	public Integer addGroup(Group group);

	public void removeGroup(int groupId);

	public void updateGroup(Group group);

	public Group getGroupById(int groupId);

	public List<Group> getAllGroups();

}
