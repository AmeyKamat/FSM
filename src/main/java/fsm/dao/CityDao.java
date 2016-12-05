package fsm.dao;

import fsm.model.domain.City;
import fsm.model.domain.Country;

import java.util.List;

public interface CityDao {

	public Integer addCity(City city);

	public void removeCity(int cityId);

	public void updateCity(City city);

	public City getCityById(int cityId);

	public List<City> getCitiesByName(String cityName);

	public List<City> getAllCities();

	public List<City> getCitiesByCountry(Country country);

}
