package pl.bendyk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.bendyk.model.others.Country;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    List<Country> findAllByOrderByName();
    Country save(Country country);
    void deleteById(Long id);

    @Query(value = "select id from countries", nativeQuery = true)
    List<Long> findCountriesIds();

}
