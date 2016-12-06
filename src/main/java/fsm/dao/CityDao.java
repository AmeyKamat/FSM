package fsm.dao;

<<<<<<< HEAD
import fsm.model.domain.City;
import fsm.model.domain.Country;

import java.util.List;

=======
import java.util.List;

import fsm.model.domain.City;
import fsm.model.domain.Country;

>>>>>>> 01b203acbe926f0a6af3a8d636bf00c13f440c3b
public interface CityDao {

	public Integer addCity(City city);

	public void removeCity(int cityId);

	public void updateCity(City city);

	public City getCityById(int cityId);

	public List<City> getCitiesByName(String cityName);

	public List<City> getAllCities();

	public List<City> getCitiesByCountry(Country country);

}
