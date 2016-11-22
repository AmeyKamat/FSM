package fsm.service.impl;

import fsm.dao.CountryDao;
import fsm.domain.Country;
import fsm.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryDao dao;

    @Transactional
    public Integer addCountry(Country country) {
        return dao.addCountry(country);
    }

    @Transactional
    public void removeCountry(int countryId) {
        dao.removeCountry(countryId);
    }

    @Transactional
    public void updateCountry(Country country) {
        dao.updateCountry(country);
    }

    @Transactional
    public Country getCountryById(int countryId) {
        return dao.getCountryById(countryId);
    }

    @Transactional
    public Country getCountryByName(String countryName) {
        return dao.getCountryByName(countryName);
    }

    @Transactional
    public List<Country> getAllCountries() {
        return dao.getAllCountries();
    }

}
