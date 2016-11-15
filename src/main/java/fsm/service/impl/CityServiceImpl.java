package fsm.service.impl;

import fsm.dao.CityDao;
import fsm.domain.City;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CityServiceImpl implements CityDao {

	@Autowired
	private CityDao dao;

	public Integer addCity(City city) {
		return	dao.addCity(city);
	}

	public void removeCity(int cityId) {
		dao.removeCity(cityId);
	}

	public void updateCity(City city) {
		dao.updateCity(city);
	}

	public City getCityById(int cityId) {
		return dao.getCityById(cityId);
	}

	@Override
	public City getCityByName(String cityName) {
		return dao.getCityByName(cityName);
	}

	public List<City> getAllCities() {

		return dao.getAllCities();
	}

}
