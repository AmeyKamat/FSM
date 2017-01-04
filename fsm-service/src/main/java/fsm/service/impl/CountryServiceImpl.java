package fsm.service.impl;

import fsm.dao.CountryDao;
import fsm.model.domain.Country;
import fsm.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryDao countryDao;

	@Override
	@Transactional
	public Integer addCountry(Country country) {
		return countryDao.addCountry(country);
	}

	@Override
	@Transactional
	public void removeCountry(int countryId) {
		countryDao.removeCountry(countryId);
	}

	@Override
	@Transactional
	public void updateCountry(Country country) {
		countryDao.updateCountry(country);
	}

	@Override
	@Transactional
	public Country getCountryById(int countryId) {
		return countryDao.getCountryById(countryId);
	}

	@Override
	@Transactional
	public Country getCountryByName(String countryName) {
		return countryDao.getCountryByName(countryName);
	}

	@Override
	@Transactional
	public List<Country> getAllCountries() {
		return countryDao.getAllCountries();
	}

}
