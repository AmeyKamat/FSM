package fsm.service;

import fsm.domain.Location;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface LocationService {

	public Integer addLocation(Location location);

	public void removeLocation(int locationId);

	public void updateLocation(Location location);

	public Location getLocationById(int locationId);

	public Location getLocationByName(String locationName);

	public List<Location> getAllLocations();

}
