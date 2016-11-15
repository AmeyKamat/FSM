package fsm.dao;

import java.util.List;

import fsm.domain.Location;

public interface LocationDao {

	public Integer addLocation(Location location);

	public void removeLocation(int locationId);

	public void updateLocation(Location location);

	public Location getLocationById(int locationId);

	public Location getLocationByName(String locationName);

	public List<Location> getAllLocations();

}
