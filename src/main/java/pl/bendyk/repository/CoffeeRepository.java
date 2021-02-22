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

    List<Coffee> findAllByOrderByPriceAsc();
    List<Coffee> findAllByOrderByPriceDesc();
    @Query(value = "select * from coffees where roastery_id in :roasteries", nativeQuery = true)
    List<Coffee> findAllByRoasteries(@Param("roasteries") List<Long> ids);

    @Query(value = "select * from coffees where " +
            "roastery_id in :roasteriesIds and " +
            "country_id in :countriesIds and " +
            "strcmp(:roast, roast) and " +
            "depulping_process_id in :depulpingProcessesIds and " +
            "strcmp(:composition, composition) and " +
            "volume_id in :volumesIds" +
            ""
            ,nativeQuery = true)
    List<Coffee> findFiltered(@Param("roasteriesIds") List<Long> roasteriesIds,
                              @Param("countriesIds") List<Long> countriesIds,
                              @Param("methodsIds") List<Long> methodsIds,
                              @Param("roast") String roast,
                              @Param("depulpingProcessesIds") List<Long> depulpingProcessesIds,
                              @Param("composition") String composition,
                              @Param("volumesIds") List<Long> volumesIds
                              );
}


/*

jeszcze trzeba będzie zjoinować dla atrybutów, które są połączone tabelam łączącymi:
- methods
- species
oraz dla atrybutów, które nie należą do kawy
- shipments (palarnia tej kawy jest w wysyłkach w jednym rekordzie z wybranym typem wysyłki)
- citi (miasto palarni tej kawy jest wśród wybranych miast)

przetestować każde z tych zapytań osobno


 */