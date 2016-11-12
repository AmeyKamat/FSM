package fsm.dao;

import java.util.List;

import fsm.domain.City;

public interface CityDao {

	public void add(City city);

	public void remove(int id);

	public void update(City city);

	public void get(int id);

	public List<City> getAll();

}
