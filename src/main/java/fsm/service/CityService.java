package fsm.service.middleLayer;

import fsm.domain.City;

import java.util.List;

public interface CityService {

	public Integer addCity(City city);

	public void removeCity(int cityId);

	public void updateCity(City city);

	public City getCityById(int cityId);

	public List<City> getAllCities();

}
