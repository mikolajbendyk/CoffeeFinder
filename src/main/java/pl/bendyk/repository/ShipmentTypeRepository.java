package pl.bendyk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bendyk.model.others.ShipmentType;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShipmentTypeRepository extends JpaRepository<ShipmentType, Long> {

    List<ShipmentType> findAll();
    List<ShipmentType> findAllByOrderByName();
    Optional<ShipmentType> findById(Long id);
    ShipmentType save(ShipmentType shipmentType);
    void deleteById(Long id);

}
