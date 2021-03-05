package pl.bendyk.service;

import pl.bendyk.model.coffee.Coffee;

import java.util.List;

public interface CoffeeService {

    List<Coffee> findAll();
    Coffee findOne(Long id);
    Coffee save(Coffee coffee);
    void delete(Long id);

    List<Coffee> findAllOrderedByName();
    List<Coffee> findAllOrderedByCountry();
    List<Coffee> findAllOrderedByRoastery();
    List<Coffee> findAllOrderedByActive();

    boolean existsForRoastery(Long id);
    boolean existsForCountry(Long id);
    boolean existsForSpecies(Long id);
    boolean existsForMethod(Long id);
    boolean existsForVolume(Long id);
    boolean existsForDepulpingProcess(Long id);

    List<Coffee> findAllActive();


    List<Coffee> findFilteredSortedAsc(
            List<Long> roasteriesIds,
            List<Long> countriesIds,
            List<Long> methodsIds,
            List<Integer> roasts,
            List<Long> depulpingProcessesIds,
            List<Integer> compositions,
            List<Long> speciesIds,
            List<Long> volumesIds,
            List<Long> shipmentTypesIds,
            List<String> cities);


    List<Coffee> findFilteredSortedDesc(
            List<Long> roasteriesIds,
            List<Long> countriesIds,
            List<Long> methodsIds,
            List<Integer> roasts,
            List<Long> depulpingProcessesIds,
            List<Integer> compositions,
            List<Long> speciesIds,
            List<Long> volumesIds,
            List<Long> shipmentTypesIds,
            List<String> cities);


    List<Coffee> findFiltered(
            List<Long> roasteriesIds,
            List<Long> countriesIds,
            List<Long> methodsIds,
            List<Integer> roasts,
            List<Long> depulpingProcessesIds,
            List<Integer> compositions,
            List<Long> speciesIds,
            List<Long> volumesIds,
            List<Long> shipmentTypesIds,
            List<String> cities
    );

}
