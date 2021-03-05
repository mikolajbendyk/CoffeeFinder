package pl.bendyk.service;

import org.springframework.stereotype.Service;
import pl.bendyk.model.others.Roastery;
import pl.bendyk.repository.RoasteryRepository;

import java.util.List;

@Service
public class RoasteryServiceImpl implements RoasteryService {

    private final RoasteryRepository roasteryRepository;

    public RoasteryServiceImpl(RoasteryRepository roasteryRepository) {
        this.roasteryRepository = roasteryRepository;
    }

    @Override
    public List<Roastery> findAll() {
        return roasteryRepository.findAllByOrderByName();
    }

    @Override
    public List<Roastery> findAllOrderedByCity() {
        return roasteryRepository.findAllByOrderByCity();
    }

    @Override
    public Roastery findOne(Long id) {
        return roasteryRepository.getOne(id);
    }

    @Override
    public Roastery save(Roastery roastery) {
        return roasteryRepository.save(roastery);
    }

    @Override
    public void delete(Long id) {
        roasteryRepository.deleteById(id);
    }

    @Override
    public List<String> findAllCities() {
        return roasteryRepository.findAllCitiesOrderByName();
    }

    @Override
    public List<Long> findRoasteriesIds() {
        return roasteryRepository.findRoasteriesIds();
    };
}
