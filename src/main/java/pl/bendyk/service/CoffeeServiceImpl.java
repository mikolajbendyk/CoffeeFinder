package pl.bendyk.service;

import org.springframework.stereotype.Service;
import pl.bendyk.model.coffee.Coffee;
import pl.bendyk.repository.CoffeeRepository;

import java.util.List;

@Service
public class CoffeeServiceImpl implements CoffeeService {

    private final CoffeeRepository coffeeRepository;

    public CoffeeServiceImpl(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    @Override
    public List<Coffee> findAll() {
        return coffeeRepository.findAll();
    }

    @Override
    public Coffee findOne(Long id) {
        return coffeeRepository.getOne(id);
    }

    @Override
    public Coffee save(Coffee coffee) {
        return coffeeRepository.save(coffee);
    }

    @Override
    public void delete(Long id) {
        coffeeRepository.deleteById(id);
    }

    @Override
    public List<Coffee> findAllOrderedByName() {
        return coffeeRepository.findAllByOrderByName();
    }

    @Override
    public List<Coffee> findAllOrderedByCountry() {
        return coffeeRepository.findAllByOrderByCountry();
    }

    @Override
    public List<Coffee> findAllOrderedByRoastery() {
        return coffeeRepository.findAllByOrderByRoastery();
    }

    @Override
    public List<Coffee> findAllOrderedByActive() {
        return coffeeRepository.findAllByOrderByActive();
    }

    @Override
    public boolean existsForRoastery(Long id) {
        return coffeeRepository.existsByRoasteryId(id);
    }

    @Override
    public boolean existsForCountry(Long id) {
        return coffeeRepository.existsByCountryId(id);
    }

    @Override
    public boolean existsForSpecies(Long id) {
        return coffeeRepository.existsBySpeciesId(id);
    }

    @Override
    public boolean existsForMethod(Long id) {
        return coffeeRepository.existsByMethodsId(id);
    }

    @Override
    public boolean existsForVolume(Long id) {
        return coffeeRepository.existsByVolumeId(id);
    }

    @Override
    public boolean existsForDepulpingProcess(Long id) {
        return coffeeRepository.existsByDepulpingProcessId(id);
    }

    @Override
    public List<Coffee> findAllActive() {
        return coffeeRepository.findAllByActiveTrue();
    }

    @Override
    public List<Coffee> findFilteredSortedAsc(
            List<Long> roasteriesIds,
            List<Long> countriesIds,
            List<Long> methodsIds,
            List<Integer> roasts,
            List<Long> depulpingProcessesIds,
            List<Integer> compositions,
            List<Long> speciesIds,
            List<Long> volumesIds,
            List<Long> shipmentTypesIds,
            List<String> cities) {
        return coffeeRepository.findFilteredSortedAsc(
                roasteriesIds, countriesIds, methodsIds, roasts, depulpingProcessesIds, compositions,
                speciesIds, volumesIds, shipmentTypesIds, cities
        );
    }

    @Override
    public List<Coffee> findFilteredSortedDesc(
            List<Long> roasteriesIds,
            List<Long> countriesIds,
            List<Long> methodsIds,
            List<Integer> roasts,
            List<Long> depulpingProcessesIds,
            List<Integer> compositions,
            List<Long> speciesIds,
            List<Long> volumesIds,
            List<Long> shipmentTypesIds,
            List<String> cities) {
        return coffeeRepository.findFilteredSortedDesc(
                roasteriesIds, countriesIds, methodsIds, roasts, depulpingProcessesIds, compositions,
                speciesIds, volumesIds, shipmentTypesIds, cities
        );
    }

    @Override
    public List<Coffee> findFiltered(
            List<Long> roasteriesIds,
            List<Long> countriesIds,
            List<Long> methodsIds,
            List<Integer> roasts,
            List<Long> depulpingProcessesIds,
            List<Integer> compositions,
            List<Long> speciesIds,
            List<Long> volumesIds,
            List<Long> shipmentTypesIds,
            List<String> cities) {
        return coffeeRepository.findFiltered(
                roasteriesIds, countriesIds, methodsIds, roasts, depulpingProcessesIds, compositions,
                speciesIds, volumesIds, shipmentTypesIds, cities
        );
    }
}
