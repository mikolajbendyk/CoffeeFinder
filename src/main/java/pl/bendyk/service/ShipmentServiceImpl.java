package pl.bendyk.service;

import org.springframework.stereotype.Service;
import pl.bendyk.model.others.Shipment;
import pl.bendyk.repository.ShipmentRepository;

import java.util.List;

@Service
public class ShipmentServiceImpl implements ShipmentService {

    private final ShipmentRepository shipmentRepository;

    public ShipmentServiceImpl(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    @Override
    public List<Shipment> findAll() {
        return shipmentRepository.findAll();
    }

    @Override
    public List<Shipment> findShipmentsForRoastery(Long id) {
        return shipmentRepository.findShipmentsForRoastery(id);
    }

    @Override
    public Shipment findOne(Long id) {
        return shipmentRepository.getOne(id);
    }

    @Override
    public Shipment save(Shipment shipment) {
        return shipmentRepository.save(shipment);
    }

    @Override
    public void delete(Long id) {
        shipmentRepository.deleteById(id);
    }

    @Override
    public boolean exists(Long id) {
        return shipmentRepository.existsByShipmentTypeId(id);
    }
}
