package fsm.dao;

import java.util.List;

import fsm.domain.City;
import org.springframework.stereotype.Repository;

@Repository
public interface CityDao {

	public Integer addCity(City city);

	public void removeCity(int cityId);

	public void updateCity(City city);

	public City getCityById(int cityId);

	public City getCityByName(String cityName);

	public List<City> getAllCities();

}
