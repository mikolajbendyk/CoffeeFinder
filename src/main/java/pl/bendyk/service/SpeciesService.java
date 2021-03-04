package pl.bendyk.service;

import pl.bendyk.model.coffee.Species;

import java.util.List;

public interface SpeciesService {

    List<Species> findAll();
    Species findOne(Long id);
    Species save(Species species);
    void delete(Long id);

}
