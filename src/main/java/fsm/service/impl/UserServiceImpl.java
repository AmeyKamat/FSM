package fsm.service.middleLayer.impl;

import fsm.dao.UserDao;
import fsm.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserDao {

	@Autowired
	private UserDao dao;
	public Integer addUser(User user) {
		return dao.addUser(user);

	}

	public void removeUser(int userId) {
		dao.removeUser(userId);
	}

	public void updateUser(User user) {
dao.updateUser(user);
	}

	public User getUserById(int userId) {
return dao.getUserById(userId);
	}

	public List<User> getAllUsers() {
return dao.getAllUsers();
	}

}
