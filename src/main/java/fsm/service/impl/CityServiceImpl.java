package fsm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fsm.dao.CityDao;
import fsm.model.domain.City;
import fsm.model.domain.Country;
import fsm.service.CityService;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityDao cityDao;

	@Override
	@Transactional
	public Integer addCity(City city) {
		return cityDao.addCity(city);
	}

	@Override
	@Transactional
	public void removeCity(int cityId) {
		cityDao.removeCity(cityId);
	}

	@Override
	@Transactional
	public void updateCity(City city) {
		cityDao.updateCity(city);
	}

	@Override
	@Transactional
	public City getCityById(int cityId) {
		return cityDao.getCityById(cityId);
	}

	@Override
	@Transactional
	public List<City> getCitiesByName(String cityName) {
		return cityDao.getCitiesByName(cityName);
	}

	@Override
	@Transactional
	public List<City> getAllCities() {

		return cityDao.getAllCities();
	}

	@Override
	@Transactional
	public List<City> getCitiesByCountry(Country country) {
		return cityDao.getCitiesByCountry(country);
	}

}
