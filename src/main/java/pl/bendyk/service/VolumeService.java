package pl.bendyk.service;

import pl.bendyk.model.coffee.Volume;

import java.util.List;

public interface VolumeService {

    List<Volume> findAll();
    Volume findOne(Long id);
    Volume save(Volume volume);
    void delete(Long id);

    List<Long> findVolumesIds();

}
