package fsm.dao;

import java.util.List;

import fsm.domain.Desk;

public interface DeskDao {

	public Integer add(Desk desk);

	public void remove(int id);

	public void update(Desk desk);

	public Desk get(int id);

	public List<Desk> getAll();

}
