package fsm.dao;

import java.util.List;

import fsm.domain.Location;

public interface LocationDao {

	public Integer add(Location location);

	public void remove(int id);

	public void update(Location location);

	public Location get(int id);

	public List<Location> getAll();

}
