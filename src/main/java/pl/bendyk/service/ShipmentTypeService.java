package pl.bendyk.service;

import pl.bendyk.model.others.ShipmentType;

import java.util.List;

public interface ShipmentTypeService {

    List<ShipmentType> findAll();
    ShipmentType findOne(Long id);
    ShipmentType save(ShipmentType shipmentType);
    void delete(Long id);

    List<Long> findShipmentTypesIds();

}
