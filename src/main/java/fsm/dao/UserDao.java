package fsm.dao;

import java.util.List;

import fsm.domain.User;

public interface UserDao {

	public Integer addUser(User user);

	public void removeUser(int userId);

	public void updateUser(User user);

	public User getUserById(int userId);

	public List<User> getAllUsers();
	
}
