package fsm.service.impl;

import fsm.dao.LocationDao;
import fsm.domain.Location;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LocationServiceImpl implements LocationDao {

	@Autowired
	private LocationDao dao;
	public Integer addLocation(Location location) {
return dao.addLocation(location);

	}

	public void removeLocation(int locationId) {
		dao.removeLocation(locationId);
	}

	public void updateLocation(Location location) {
	dao.updateLocation(location);
	}

	public Location getLocationById(int locationId) {
return dao.getLocationById(locationId);
	}

	@Override
	public Location getLocationByName(String locationName) {
		return dao.getLocationByName(locationName);
	}

	public List<Location> getAllLocations() {
return dao.getAllLocations();
	}

}
