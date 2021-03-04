package pl.bendyk.service;

import org.springframework.data.jpa.repository.Query;
import pl.bendyk.model.others.Shipment;

import java.util.List;

public interface ShipmentService {

    List<Shipment> findAll();
    List<Shipment> findShipmentsForRoastery(Long id);
    Shipment save(Shipment shipment);
    void deleteById(Long id);
    boolean exists(Long id);

}
