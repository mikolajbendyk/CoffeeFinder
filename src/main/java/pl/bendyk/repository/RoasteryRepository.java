package pl.bendyk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.bendyk.model.others.Roastery;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoasteryRepository extends JpaRepository<Roastery, Long> {

    List<Roastery> findAllByOrderByName();
    List<Roastery> findAllByOrderByCity();
    Roastery save(Roastery roastery);
    void deleteById(Long id);

    @Query(value = "select distinct city from roasteries order by city", nativeQuery = true)
    List<String> findAllCitiesOrderByName();

    @Query(value = "select id from roasteries", nativeQuery = true)
    List<Long> findRoasteriesIds();

}
