package fsm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fsm.dao.GroupDao;
import fsm.model.domain.Group;
import fsm.service.GroupService;

@Service
public class GroupServiceImpl implements GroupService {

	@Autowired
	private GroupDao groupDao;

	@Override
	@Transactional
	public Integer addGroup(Group group) {
		return groupDao.addGroup(group);

	}

	@Override
	@Transactional
	public void removeGroup(int groupId) {

		groupDao.removeGroup(groupId);
	}

	@Override
	@Transactional
	public void updateGroup(Group group) {
		groupDao.updateGroup(group);
	}

	@Override
	@Transactional
	public Group getGroupById(int groupId) {
		return groupDao.getGroupById(groupId);
	}

	@Override
	@Transactional
	public List<Group> getAllGroups() {

		return groupDao.getAllGroups();
	}

}
