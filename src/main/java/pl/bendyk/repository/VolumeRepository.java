package pl.bendyk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bendyk.model.coffee.Volume;

import java.util.List;
import java.util.Optional;

@Repository
public interface VolumeRepository extends JpaRepository<Volume, Long> {

    List<Volume> findAll();
    List<Volume> findAllByOrderByGrams();
    Optional<Volume> findById(Long id);
    Volume save(Volume volume);
    void deleteById(Long id);

}
