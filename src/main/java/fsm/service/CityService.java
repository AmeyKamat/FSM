package fsm.service;

import java.util.List;
import fsm.model.domain.City;
import fsm.model.domain.Country;

public interface CityService {

	public Integer addCity(City city);

	public void removeCity(int cityId);

	public void updateCity(City city);

	public City getCityById(int cityId);

	public List<City> getCitiesByName(String cityName);
	
	public List<City> getCitiesByCountry(Country country);

	public List<City> getAllCities();
}
