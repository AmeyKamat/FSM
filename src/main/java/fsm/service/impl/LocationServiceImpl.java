package fsm.service.impl;

import fsm.dao.LocationDao;
import fsm.domain.Location;
import fsm.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationDao dao;

	@Transactional
	public Integer addLocation(Location location) {
		return dao.addLocation(location);
	}

	@Transactional
	public void removeLocation(int locationId) {
		dao.removeLocation(locationId);
	}

	@Transactional
	public void updateLocation(Location location) {
	dao.updateLocation(location);
	}

	@Transactional
	public Location getLocationById(int locationId) {
return dao.getLocationById(locationId);
	}


	@Transactional
	public Location getLocationByName(String locationName) {
		return dao.getLocationByName(locationName);
	}

	@Transactional
	public List<Location> getAllLocations() {
return dao.getAllLocations();
	}

}
