package pl.bendyk.service;

import org.springframework.stereotype.Service;
import pl.bendyk.model.others.ShipmentType;
import pl.bendyk.repository.ShipmentTypeRepository;

import java.util.List;

@Service
public class ShipmentTypeServiceImpl implements ShipmentTypeService {

    private final ShipmentTypeRepository shipmentTypeRepository;

    public ShipmentTypeServiceImpl(ShipmentTypeRepository shipmentTypeRepository) {
        this.shipmentTypeRepository = shipmentTypeRepository;
    }

    @Override
    public List<ShipmentType> findAll() {
        return shipmentTypeRepository.findAllByOrderByName();
    }

    @Override
    public ShipmentType findOne(Long id) {
        return shipmentTypeRepository.getOne(id);
    }

    @Override
    public ShipmentType save(ShipmentType shipmentType) {
        return shipmentTypeRepository.save(shipmentType);
    }

    @Override
    public void delete(Long id) {
        shipmentTypeRepository.deleteById(id);
    }

    @Override
    public List<Long> findShipmentTypesIds() {
        return shipmentTypeRepository.findShipmentTypesIds();
    }
}
