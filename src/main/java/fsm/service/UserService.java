package fsm.service;

import fsm.domain.User;

import java.util.List;

public interface UserService {

	public Integer addUser(User user);

	public void removeUser(int userId);

	public void updateUser(User user);

	public User getUserById(int userId);

	public List<User> getAllUsers();
	
}
