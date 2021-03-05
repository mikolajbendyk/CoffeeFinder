package pl.bendyk.service;

import pl.bendyk.model.others.Shipment;

import java.util.List;

public interface ShipmentService {

    List<Shipment> findAll();
    List<Shipment> findShipmentsForRoastery(Long id);
    Shipment findOne(Long id);
    Shipment save(Shipment shipment);
    void delete(Long id);
    boolean exists(Long id);

}
