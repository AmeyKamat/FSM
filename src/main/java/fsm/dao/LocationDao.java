package fsm.dao;

import java.util.List;

import fsm.domain.Location;

public interface LocationDao {

	public void add(Location location);

	public void remove(int id);

	public void update(Location location);

	public void get(int id);

	public List<Location> getAll();

}
