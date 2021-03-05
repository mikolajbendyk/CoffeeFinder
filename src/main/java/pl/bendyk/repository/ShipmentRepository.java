package pl.bendyk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.bendyk.model.others.Shipment;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Long> {

    List<Shipment> findAll();

    @Query(value = "select * from shipments where roastery_id = ?1", nativeQuery = true)
    List<Shipment> findShipmentsForRoastery(Long id);

    Shipment save(Shipment shipment);

    void deleteById(Long id);

    boolean existsByShipmentTypeId(Long id);

}
