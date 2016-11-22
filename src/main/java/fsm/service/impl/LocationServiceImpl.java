package fsm.service.impl;

import fsm.dao.CityDao;
import fsm.dao.LocationDao;
import fsm.domain.City;
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

    @Autowired
    private CityDao daoCity;

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

    @Transactional
    public List<Location> getAllLocations(int cityId) {
        City city = daoCity.getCityById(cityId);
        return dao.getAllLocations(city);
    }

}
