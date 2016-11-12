package fsm.dao;

import java.util.List;

import fsm.domain.User;

public interface UserDao {

	public void add(User user);

	public void remove(int id);

	public void update(User user);

	public void get(int id);

	public List<User> getAll();
	
}
