package fsm.service.middleLayer.impl;

import fsm.dao.CountryDao;
import fsm.domain.Country;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CountryServiceImpl implements CountryDao {

	@Autowired
	private CountryDao dao;

	public Integer addCountry(Country country) {
	return dao.addCountry(country);
	}

	public void removeCountry(int countryId) {
		dao.removeCountry(countryId);
	}

	public void updateCountry(Country country) {
		dao.updateCountry(country);
	}

	public Country getCountryById(int countryId) {
		return dao.getCountryById(countryId);
	}

	public List<Country> getAllCountries() {
	return	dao.getAllCountries();
	}

}
