package fsm.dao;

import java.util.List;

import fsm.domain.City;
import fsm.domain.Location;
import org.springframework.stereotype.Repository;

public interface LocationDao {

	public Integer addLocation(Location location);

	public void removeLocation(int locationId);

	public void updateLocation(Location location);

	public Location getLocationById(int locationId);

	public List<Location> getLocationsByName(String locationName);

	public List<Location> getAllLocations();

    List<Location> getAllLocationsByCity(City city);
}
