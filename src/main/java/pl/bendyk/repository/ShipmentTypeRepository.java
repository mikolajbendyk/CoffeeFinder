package pl.bendyk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.bendyk.model.others.ShipmentType;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShipmentTypeRepository extends JpaRepository<ShipmentType, Long> {

    List<ShipmentType> findAllByOrderByName();
    ShipmentType save(ShipmentType shipmentType);
    void deleteById(Long id);

    @Query(value = "select id from shipment_types", nativeQuery = true)
    List<Long> findShipmentTypesIds();
}
