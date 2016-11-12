package fsm.dao;

import java.util.List;

import fsm.domain.Desk;

public interface DeskDao {

	public void add(Desk desk);

	public void remove(int id);

	public void update(Desk desk);

	public void get(int id);

	public List<Desk> getAll();

}
