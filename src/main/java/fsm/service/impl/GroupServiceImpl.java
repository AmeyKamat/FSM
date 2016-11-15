package fsm.service.impl;

import fsm.dao.GroupDao;
import fsm.domain.Group;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GroupServiceImpl implements GroupDao {

	@Autowired
	private GroupDao dao;
	public Integer addGroup(Group group) {
		return dao.addGroup(group);

	}

	public void removeGroup(int groupId) {

		dao.removeGroup(groupId);
	}

	public void updateGroup(Group group) {
dao.updateGroup(group);
	}

	public Group getGroupById(int groupId) {
return dao.getGroupById(groupId);
	}

	public List<Group> getAllGroups() {

		return dao.getAllGroups();
	}

}
