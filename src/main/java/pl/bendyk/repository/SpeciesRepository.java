package pl.bendyk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bendyk.model.coffee.Method;
import pl.bendyk.model.coffee.Species;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpeciesRepository extends JpaRepository {

    List<Species> findAll();
    Optional<Species> findById(Long id);
    Species save(Species species);
    void deleteById(Long id);

}
