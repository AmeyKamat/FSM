package fsm.service.impl;

import fsm.dao.LocationDao;
import fsm.model.domain.City;
import fsm.model.domain.Location;
import fsm.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationDao locationDao;

	@Override
	@Transactional
	public Integer addLocation(Location location) {
		return locationDao.addLocation(location);
	}

	@Override
	@Transactional
	public void removeLocation(int locationId) {
		locationDao.removeLocation(locationId);
	}

	@Override
	@Transactional
	public void updateLocation(Location location) {
		locationDao.updateLocation(location);
	}

	@Override
	@Transactional
	public Location getLocationById(int locationId) {
		if (locationDao == null) {
			System.out.println("Location dao is null");
		}

		return locationDao.getLocationById(locationId);
	}

	@Override
	@Transactional
	public List<Location> getLocationsByName(String locationName) {
		return locationDao.getLocationsByName(locationName);
	}

	@Override
	@Transactional
	public List<Location> getAllLocations() {
		return locationDao.getAllLocations();
	}

	@Override
	@Transactional
	public List<Location> getAllLocationsByCity(City city) {
		return locationDao.getAllLocationsByCity(city);
	}

}
