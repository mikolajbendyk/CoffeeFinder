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
    Coffee save(Coffee coffee);
    void deleteById(Long id);

    List<Coffee> findAllByOrderByName();
    List<Coffee> findAllByOrderByCountry();
    @Query(value = "select c.* from coffees c join roasteries r on c.roastery_id = r.id order by r.name;", nativeQuery = true)
    List<Coffee> findAllByOrderByRoastery();
    List<Coffee> findAllByOrderByActive();

    boolean existsByRoasteryId(Long id);
    boolean existsByCountryId(Long id);
    boolean existsBySpeciesId(Long id);
    boolean existsByMethodsId(Long id);
    boolean existsByVolumeId(Long id);
    boolean existsByDepulpingProcessId(Long id);

    List<Coffee> findAllByActiveTrue();


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
