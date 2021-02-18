package pl.bendyk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bendyk.model.others.Shipment;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Long> {

    List<Shipment> findAll();
    Optional<Shipment> findById(Long id);
    Shipment save(Shipment shipment);
    void deleteById(Long id);

}
