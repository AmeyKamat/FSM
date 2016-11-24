package fsm.dao;

import java.util.List;

import fsm.domain.City;
import fsm.domain.Country;

public interface CityDao {

	public Integer addCity(City city);

	public void removeCity(int cityId);

	public void updateCity(City city);

	public City getCityById(int cityId);

	public List<City> getCitiesByName(String cityName);

	public List<City> getAllCities();

	public List<City> getCitiesByCountry(Country country);

}
