package fsm.service.impl;

import fsm.dao.GroupDao;
import fsm.domain.Group;
import fsm.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class GroupServiceImpl implements GroupService {

	@Autowired
	private GroupDao dao;
	@Transactional
	public Integer addGroup(Group group) {
		return dao.addGroup(group);

	}

	@Transactional
	public void removeGroup(int groupId) {

		dao.removeGroup(groupId);
	}

	@Transactional
	public void updateGroup(Group group) {
dao.updateGroup(group);
	}

	@Transactional
	public Group getGroupById(int groupId) {
return dao.getGroupById(groupId);
	}

	@Transactional
	public List<Group> getAllGroups() {

		return dao.getAllGroups();
	}

}
