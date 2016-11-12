package fsm.dao;

import java.util.List;

import fsm.domain.Floor;

public interface FloorDao {

	public void add(Floor floor);

	public void remove(int id);

	public void update(Floor floor);

	public void get(int id);

	public List<Floor> getAll();

}
