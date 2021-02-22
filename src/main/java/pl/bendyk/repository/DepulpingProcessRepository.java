package pl.bendyk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bendyk.model.coffee.DepulpingProcess;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepulpingProcessRepository extends JpaRepository<DepulpingProcess, Long> {

    List<DepulpingProcess> findAll();
    Optional<DepulpingProcess> findById(Long id);
    DepulpingProcess save(DepulpingProcess depulpingProcess);
    void deleteById(Long id);

}