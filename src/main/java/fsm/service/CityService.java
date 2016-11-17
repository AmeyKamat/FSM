package fsm.service;

import fsm.domain.City;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CityService {

	public Integer addCity(City city);

	public void removeCity(int cityId);

	public void updateCity(City city);

	public City getCityById(int cityId);

	public City getCityByName(String cityName);


	public List<City> getAllCities();

}
