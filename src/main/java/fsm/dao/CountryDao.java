package fsm.dao;

import java.util.List;

import fsm.domain.Country;

public interface CountryDao {

	public Integer add(Country country);

	public void remove(int id);

	public void update(Country country);

	public Country get(int id);

	public List<Country> getAll();

}