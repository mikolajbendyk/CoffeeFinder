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
    Optional<Shipment> findById(Long id);

    @Query(value = "select s.* from shipments s join roasteries_shipments rs on s.id = rs.shipments_id " +
            "join roasteries r on r.id = rs.roastery_id where r.id = ?1", nativeQuery = true)
    List<Shipment> findShipmentsForRoastery(Long id);

    Shipment save(Shipment shipment);
    void deleteById(Long id);

    @Modifying
    @Transactional
    @Query(value = "delete from roasteries_shipments where shipments_id = ?1", nativeQuery = true)
    void deleteChild(Long id);


    //dodać drugi parametr określający palarnię, bo teraz usunie tę wysyłkę dla wszystkich palarni
}
