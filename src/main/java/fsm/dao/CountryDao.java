package fsm.dao;

import java.util.HashMap;
import java.util.List;

import fsm.domain.Country;
import org.springframework.stereotype.Repository;

//@Repository
public interface CountryDao {

	public Integer addCountry(Country country);

	public void removeCountry(int countryId);

	public void updateCountry(Country country);

	public Country getCountryById(int countryId);

	public List<Country> getAllCountries();

	Country getCountryByName(String countryName);
}