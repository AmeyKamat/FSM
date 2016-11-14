package fsm.service.middleLayer;

import fsm.domain.Country;

import java.util.List;

public interface CountryService {

	public Integer addCountry(Country country);

	public void removeCountry(int countryId);

	public void updateCountry(Country country);

	public Country getCountryById(int countryId);

	public List<Country> getAllCountries();

}