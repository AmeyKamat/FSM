package fsm.service;

import java.util.List;

import fsm.model.domain.Group;

public interface GroupService {

	public Integer addGroup(Group group);

	public void removeGroup(int groupId);

	public void updateGroup(Group group);

	public Group getGroupById(int groupId);

	public List<Group> getAllGroups();
	
}
