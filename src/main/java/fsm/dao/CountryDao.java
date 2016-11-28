package fsm.dao;

import java.util.List;

import fsm.model.domain.Country;

public interface CountryDao {

	public Integer addCountry(Country country);

	public void removeCountry(int countryId);

	public void updateCountry(Country country);

	public Country getCountryById(int countryId);

	public List<Country> getAllCountries();

	Country getCountryByName(String countryName);
}