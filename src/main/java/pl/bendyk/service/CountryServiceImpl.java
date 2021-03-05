package pl.bendyk.service;

import org.springframework.stereotype.Service;
import pl.bendyk.model.others.Country;
import pl.bendyk.repository.CountryRepository;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAllByOrderByName();
    }

    @Override
    public Country findOne(Long id) {
        return countryRepository.getOne(id);
    }

    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public void delete(Long id) {
        countryRepository.deleteById(id);
    }

    @Override
    public List<Long> findCountriesIds() {
        return countryRepository.findCountriesIds();
    }
}
