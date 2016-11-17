package fsm.service.impl;

import fsm.dao.UserDao;
import fsm.domain.User;
import fsm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;

	@Transactional
	public Integer addUser(User user) {
		return dao.addUser(user);

	}

	@Transactional
	public void removeUser(int userId) {
		dao.removeUser(userId);
	}

	@Transactional
	public void updateUser(User user) {
dao.updateUser(user);
	}

	@Transactional
	public User getUserById(int userId) {
return dao.getUserById(userId);
	}

	@Transactional
	public List<User> getAllUsers() {
return dao.getAllUsers();
	}

	@Override
	public User getUserByUsername(String username) {
		return dao.getUserByUsername(username);
	}

}
