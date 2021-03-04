package pl.bendyk.service;

import org.springframework.stereotype.Service;
import pl.bendyk.model.coffee.Species;
import pl.bendyk.repository.SpeciesRepository;

import java.util.List;

@Service
public class SpeciesServiceImpl implements SpeciesService {

    private final SpeciesRepository speciesRepository;

    public SpeciesServiceImpl(SpeciesRepository speciesRepository) {
        this.speciesRepository = speciesRepository;
    }

    @Override
    public List<Species> findAll() {
        return speciesRepository.findAllByOrderByName();
    }

    @Override
    public Species findOne(Long id) {
        return speciesRepository.getOne(id);
    }

    @Override
    public Species save(Species species) {
        return speciesRepository.save(species);
    }

    @Override
    public void delete(Long id) {
        speciesRepository.deleteById(id);
    }
}
