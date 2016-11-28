package fsm.service;

import java.util.List;

import fsm.model.domain.Country;

public interface CountryService {

	public Integer addCountry(Country country);

	public void removeCountry(int countryId);

	public void updateCountry(Country country);

	public Country getCountryById(int countryId);

	public Country getCountryByName(String countryName);

	public List<Country> getAllCountries();

}