package fsm.dao;

import fsm.model.domain.City;
import fsm.model.domain.Location;

import java.util.List;

public interface LocationDao {

	public Integer addLocation(Location location);

	public void removeLocation(int locationId);

	public void updateLocation(Location location);

	public Location getLocationById(int locationId);

	public List<Location> getLocationsByName(String locationName);

	public List<Location> getAllLocations();

    List<Location> getAllLocationsByCity(City city);
}
