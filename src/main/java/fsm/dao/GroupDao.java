package fsm.dao;

import java.util.List;

import fsm.model.domain.Group;

public interface GroupDao {

	public Integer addGroup(Group group);

	public void removeGroup(int groupId);

	public void updateGroup(Group group);

	public Group getGroupById(int groupId);

	public List<Group> getAllGroups();

}
