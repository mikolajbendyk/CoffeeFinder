package pl.bendyk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bendyk.model.coffee.Coffee;

import java.util.List;
import java.util.Optional;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Long> {

    List<Coffee> findAllByOrderByName();
    Optional<Coffee> findById(Long id);
    Coffee save(Coffee coffee);
    void deleteById(Long id);

    boolean existsByRoasteryId(Long id);
    boolean existsByCountryId(Long id);
    boolean existsBySpeciesId(Long id);
    boolean existsByMethodsId(Long id);
    boolean existsByVolumesId(Long id);

}
