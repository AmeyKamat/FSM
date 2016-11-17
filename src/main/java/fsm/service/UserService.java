package fsm.service;

import fsm.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {

	public Integer addUser(User user);

	public void removeUser(int userId);

	public void updateUser(User user);

	public User getUserById(int userId);

	public List<User> getAllUsers();

    User getUserByUsername(String username);
}
