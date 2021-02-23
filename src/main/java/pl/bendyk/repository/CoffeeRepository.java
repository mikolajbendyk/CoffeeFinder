package pl.bendyk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.bendyk.model.coffee.Coffee;

import java.util.List;
import java.util.Optional;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Long> {

    List<Coffee> findAll();
    List<Coffee> findAllByOrderByName();
    Optional<Coffee> findById(Long id);
    Coffee save(Coffee coffee);
    void deleteById(Long id);

    boolean existsByRoasteryId(Long id);
    boolean existsByCountryId(Long id);
    boolean existsBySpeciesId(Long id);
    boolean existsByMethodsId(Long id);
    boolean existsByVolumeId(Long id);
    boolean existsByDepulpingProcessId(Long id);

    List<Coffee> findAllByActiveTrue();


    //testowe query

    List<Coffee> findAllByOrderByPriceAsc();
    List<Coffee> findAllByOrderByPriceDesc();

    @Query(value = "select * from coffees where roastery_id in :roasteries", nativeQuery = true)
    List<Coffee> findAllByRoasteries(@Param("roasteries") List<Long> ids);

    @Query(value = "select * from coffees where country_id in :countries", nativeQuery = true)
    List<Coffee> findAllByCountries(@Param("countries") List<Long> ids);

    @Query(value = "select distinct c.* from coffees c " +
            "join coffees_methods cm on c.id = cm.coffee_id " +
            "join methods m on cm.methods_id = m.id " +
            "where m.id in :methods", nativeQuery = true)
    List<Coffee> findAllByMethods(@Param("methods") List<Long> ids);

    @Query(value = "select * from coffees where roast in :roasts", nativeQuery = true)
    List<Coffee> findAllByRoasts(@Param("roasts") List<Integer> roasts);

    @Query(value = "select * from coffees where depulping_process_id in :depulpingProcesses", nativeQuery = true)
    List<Coffee> findAllByDepulpingProcess(@Param("depulpingProcesses") List<Long> ids);

    @Query(value = "select * from coffees where composition in :compositions", nativeQuery = true)
    List<Coffee> findAllByCompositions(@Param("compositions") List<Integer> compositions);

    @Query(value = "select distinct c.* from coffees c " +
            "join coffees_species cs on c.id = cs.coffee_id " +
            "join species s on cs.species_id = s.id " +
            "where s.id in :species", nativeQuery = true)
    List<Coffee> findAllBySpecies(@Param("species") List<Long> ids);

    @Query(value = "select * from coffees where volume_id in :volumes", nativeQuery = true)
    List<Coffee> findAllByVolumes(@Param("volumes") List<Long> ids);

    @Query(value = "select * from coffees where roastery_id in " +
            "(select distinct roastery_id from shipments " +
            "where shipment_type_id in :shipmentTypes)", nativeQuery = true)
    List<Coffee> findAllByShipmentType(@Param("shipmentTypes") List<Long> ids);

    @Query(value = "select * from coffees where roastery_id in " +
            "(select distinct id from roasteries where city in :cities)", nativeQuery = true)
    List<Coffee> findAllByCity(@Param("cities") List<String> cities);


//    queries zwracające id danych atrybutów

    @Query(value = "select id from roasteries", nativeQuery = true)
    List<Long> findRoasteriesIds();

    @Query(value = "select id from countries", nativeQuery = true)
    List<Long> findCountriesIds();

    @Query(value = "select id from methods", nativeQuery = true)
    List<Long> findMethodsIds();

    @Query(value = "select id from processes", nativeQuery = true)
    List<Long> findDepulpingProcessesIds();

    @Query(value = "select id from species", nativeQuery = true)
    List<Long> findSpeciesIds();

    @Query(value = "select id from volumes", nativeQuery = true)
    List<Long> findVolumesIds();

    @Query(value = "select id from shipment_types", nativeQuery = true)
    List<Long> findShipmentTypesIds();




    @Query(value = "select distinct c.* from coffees c " +
            "join coffees_methods cm on c.id = cm.coffee_id " +
            "join methods m on cm.methods_id = m.id " +
            "join coffees_species cs on c.id = cs.coffee_id " +
            "join species s on cs.species_id = s.id " +
            "where " +
            "c.roastery_id in :roasteriesIds and " +
            "c.country_id in :countriesIds and " +
            "m.id in :methodsIds and " +
            "c.roast in :roasts and " +
            "c.depulping_process_id in :depulpingProcessesIds and " +
            "c.composition in :compositions and " +
            "s.id in :speciesIds and " +
            "c.volume_id in :volumesIds and " +
            "c.roastery_id in " +
            "    (select distinct roastery_id from shipments " +
            "        where shipment_type_id in :shipmentTypesIds) and " +
            "c.roastery_id in " +
            "    (select distinct id from roasteries " +
            "        where city in :cities) " +
            "order by c.price asc;"
            ,nativeQuery = true)
    List<Coffee> findFilteredSortedAsc(
            @Param("roasteriesIds") List<Long> roasteriesIds,
            @Param("countriesIds") List<Long> countriesIds,
            @Param("methodsIds") List<Long> methodsIds,
            @Param("roasts") List<Integer> roasts,
            @Param("depulpingProcessesIds") List<Long> depulpingProcessesIds,
            @Param("compositions") List<Integer> compositions,
            @Param("speciesIds") List<Long> speciesIds,
            @Param("volumesIds") List<Long> volumesIds,
            @Param("shipmentTypesIds") List<Long> shipmentTypesIds,
            @Param("cities") List<String> cities);

    @Query(value = "select distinct c.* from coffees c " +
            "join coffees_methods cm on c.id = cm.coffee_id " +
            "join methods m on cm.methods_id = m.id " +
            "join coffees_species cs on c.id = cs.coffee_id " +
            "join species s on cs.species_id = s.id " +
            "where " +
            "c.roastery_id in :roasteriesIds and " +
            "c.country_id in :countriesIds and " +
            "m.id in :methodsIds and " +
            "c.roast in :roasts and " +
            "c.depulping_process_id in :depulpingProcessesIds and " +
            "c.composition in :compositions and " +
            "s.id in :speciesIds and " +
            "c.volume_id in :volumesIds and " +
            "c.roastery_id in " +
            "    (select distinct roastery_id from shipments " +
            "        where shipment_type_id in :shipmentTypesIds) and " +
            "c.roastery_id in " +
            "    (select distinct id from roasteries " +
            "        where city in :cities) " +
            "order by c.price desc;"
            ,nativeQuery = true)
    List<Coffee> findFilteredSortedDesc(
            @Param("roasteriesIds") List<Long> roasteriesIds,
            @Param("countriesIds") List<Long> countriesIds,
            @Param("methodsIds") List<Long> methodsIds,
            @Param("roasts") List<Integer> roasts,
            @Param("depulpingProcessesIds") List<Long> depulpingProcessesIds,
            @Param("compositions") List<Integer> compositions,
            @Param("speciesIds") List<Long> speciesIds,
            @Param("volumesIds") List<Long> volumesIds,
            @Param("shipmentTypesIds") List<Long> shipmentTypesIds,
            @Param("cities") List<String> cities);

    @Query(value = "select distinct c.* from coffees c " +
            "join coffees_methods cm on c.id = cm.coffee_id " +
            "join methods m on cm.methods_id = m.id " +
            "join coffees_species cs on c.id = cs.coffee_id " +
            "join species s on cs.species_id = s.id " +
            "where " +
            "c.roastery_id in :roasteriesIds and " +
            "c.country_id in :countriesIds and " +
            "m.id in :methodsIds and " +
            "c.roast in :roasts and " +
            "c.depulping_process_id in :depulpingProcessesIds and " +
            "c.composition in :compositions and " +
            "s.id in :speciesIds and " +
            "c.volume_id in :volumesIds and " +
            "c.roastery_id in " +
            "    (select distinct roastery_id from shipments " +
            "        where shipment_type_id in :shipmentTypesIds) and " +
            "c.roastery_id in " +
            "    (select distinct id from roasteries " +
            "        where city in :cities);"
            ,nativeQuery = true)
    List<Coffee> findFiltered(
            @Param("roasteriesIds") List<Long> roasteriesIds,
            @Param("countriesIds") List<Long> countriesIds,
            @Param("methodsIds") List<Long> methodsIds,
            @Param("roasts") List<Integer> roasts,
            @Param("depulpingProcessesIds") List<Long> depulpingProcessesIds,
            @Param("compositions") List<Integer> compositions,
            @Param("speciesIds") List<Long> speciesIds,
            @Param("volumesIds") List<Long> volumesIds,
            @Param("shipmentTypesIds") List<Long> shipmentTypesIds,
            @Param("cities") List<String> cities
    );
}


/*

jak wyciągnąć wszystkie ordinale enumów?



 */