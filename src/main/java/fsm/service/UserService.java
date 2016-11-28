package fsm.service;

import java.util.List;

import fsm.model.domain.User;

public interface UserService {

	public Integer addUser(User user);

	public void removeUser(int userId);

	public void updateUser(User user);

	public User getUserById(int userId);

	public List<User> getAllUsers();

    User getUserByUsername(String username);

    String checkLogin(String username, String password);
}
