package pl.bendyk.service;

import pl.bendyk.model.others.Roastery;

import java.util.List;

public interface RoasteryService {

    List<Roastery> findAll();
    List<Roastery> findAllOrderedByCity();
    Roastery findOne(Long id);
    Roastery save(Roastery roastery);
    void delete(Long id);

    List<String> findAllCities();

    List<Long> findRoasteriesIds();

}
