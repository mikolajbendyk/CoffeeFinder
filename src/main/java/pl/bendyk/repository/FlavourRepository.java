package pl.bendyk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bendyk.model.coffee.Flavour;

import java.util.List;
import java.util.Optional;

@Repository
public interface FlavourRepository extends JpaRepository<Flavour, Long> {

    List<Flavour> findAllByOrderByName();
    Optional<Flavour> findById(Long id);
    Flavour save(Flavour flavour);
    void deleteById(Long id);

}
