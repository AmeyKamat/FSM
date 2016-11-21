package fsm.dao;

import java.util.List;

import fsm.domain.City;
import fsm.domain.Country;
import org.springframework.stereotype.Repository;

//@Repository
public interface CityDao {

	public Integer addCity(City city);

	public void removeCity(int cityId);

	public void updateCity(City city);

	public City getCityById(int cityId);

	public City getCityByName(String cityName);

	public List<City> getAllCities();

	public List<City> getAllCities(Country country);

}
