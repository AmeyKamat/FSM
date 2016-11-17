package fsm.dao;

import java.util.List;

import fsm.domain.Group;
import org.springframework.stereotype.Repository;

//@Repository
public interface GroupDao {

	public Integer addGroup(Group group);

	public void removeGroup(int groupId);

	public void updateGroup(Group group);

	public Group getGroupById(int groupId);

	public List<Group> getAllGroups();
	
}
