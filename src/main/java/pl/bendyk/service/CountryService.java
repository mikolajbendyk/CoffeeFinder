package pl.bendyk.service;

import pl.bendyk.model.others.Country;

import java.util.List;

public interface CountryService {

    List<Country> findAll();
    Country findOne(Long id);
    Country save(Country country);
    void delete(Long id);

    List<Long> findCountriesIds();

}
