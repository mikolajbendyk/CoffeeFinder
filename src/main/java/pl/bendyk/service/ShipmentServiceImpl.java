package pl.bendyk.service;

import org.springframework.stereotype.Service;
import pl.bendyk.model.others.Shipment;

import java.util.List;

@Service
public class ShipmentServiceImpl implements ShipmentService {



    @Override
    public List<Shipment> findAll() {
        return null;
    }

    @Override
    public List<Shipment> findShipmentsForRoastery(Long id) {
        return null;
    }

    @Override
    public Shipment save(Shipment shipment) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public boolean exists(Long id) {
        return false;
    }
}
