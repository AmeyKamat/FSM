package fsm.service;

import fsm.model.domain.Country;

import java.util.List;

public interface CountryService {

	public Integer addCountry(Country country);

	public void removeCountry(int countryId);

	public void updateCountry(Country country);

	public Country getCountryById(int countryId);

	public Country getCountryByName(String countryName);

	public List<Country> getAllCountries();

}