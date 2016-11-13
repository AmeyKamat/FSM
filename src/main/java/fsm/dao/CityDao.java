package fsm.dao;

import java.util.List;

import fsm.domain.City;

public interface CityDao {

	public Integer add(City city);

	public void remove(int id);

	public void update(City city);

	public City get(int id);

	public List<City> getAll();

}
