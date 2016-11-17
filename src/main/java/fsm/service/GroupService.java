package fsm.service;

import fsm.domain.Group;
import org.springframework.stereotype.Service;

import java.util.List;

public interface GroupService {

	public Integer addGroup(Group group);

	public void removeGroup(int groupId);

	public void updateGroup(Group group);

	public Group getGroupById(int groupId);

	public List<Group> getAllGroups();
	
}
