package pl.bendyk.service;

import org.springframework.stereotype.Service;
import pl.bendyk.model.coffee.Volume;
import pl.bendyk.repository.VolumeRepository;

import java.util.List;

@Service
public class VolumeServiceImpl implements VolumeService {

    private final VolumeRepository volumeRepository;

    public VolumeServiceImpl(VolumeRepository volumeRepository) {
        this.volumeRepository = volumeRepository;
    }

    @Override
    public List<Volume> findAll() {
        return volumeRepository.findAllByOrderByGrams();
    }

    @Override
    public Volume findOne(Long id) {
        return volumeRepository.getOne(id);
    }

    @Override
    public Volume save(Volume volume) {
        return volumeRepository.save(volume);
    }

    @Override
    public void delete(Long id) {
        volumeRepository.deleteById(id);
    }

    @Override
    public List<Long> findVolumesIds() {
        return volumeRepository.findVolumesIds();
    }
}
