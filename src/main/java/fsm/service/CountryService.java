package fsm.service;

import fsm.domain.Country;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CountryService {

	public Integer addCountry(Country country);

	public void removeCountry(int countryId);

	public void updateCountry(Country country);

	public Country getCountryById(int countryId);

	public Country getCountryByName(String countryName);

	public List<Country> getAllCountries();

}