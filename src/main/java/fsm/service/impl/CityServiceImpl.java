package fsm.service.impl;

import fsm.dao.CityDao;
import fsm.domain.City;
import fsm.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityDao dao;

	@Transactional
	public Integer addCity(City city) {
		return	dao.addCity(city);
	}

	@Transactional
	public void removeCity(int cityId) {
		dao.removeCity(cityId);
	}

	@Transactional
	public void updateCity(City city) {
		dao.updateCity(city);
	}

	@Transactional
	public City getCityById(int cityId) {
		return dao.getCityById(cityId);
	}

	@Transactional
	public City getCityByName(String cityName) {
		return dao.getCityByName(cityName);
	}

	@Transactional
	public List<City> getAllCities() {

		return dao.getAllCities();
	}

}
