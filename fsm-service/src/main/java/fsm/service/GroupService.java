package fsm.service;

import fsm.model.domain.Group;

import java.util.List;

public interface GroupService {

	public Integer addGroup(Group group);

	public void removeGroup(int groupId);

	public void updateGroup(Group group);

	public Group getGroupById(int groupId);

	public List<Group> getAllGroups();
	
}
