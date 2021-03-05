package pl.bendyk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.bendyk.model.coffee.Volume;

import java.util.List;
import java.util.Optional;

@Repository
public interface VolumeRepository extends JpaRepository<Volume, Long> {

    List<Volume> findAllByOrderByGrams();
    Volume save(Volume volume);
    void deleteById(Long id);

    @Query(value = "select id from volumes", nativeQuery = true)
    List<Long> findVolumesIds();

}
