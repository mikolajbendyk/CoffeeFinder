package pl.bendyk.service;

import org.springframework.stereotype.Service;
import pl.bendyk.model.coffee.DepulpingProcess;
import pl.bendyk.repository.DepulpingProcessRepository;

import java.util.List;

@Service
public class DepulpingProcessServiceImpl implements DepulpingProcessService {

    private final DepulpingProcessRepository depulpingProcessRepository;

    public DepulpingProcessServiceImpl(DepulpingProcessRepository depulpingProcessRepository) {
        this.depulpingProcessRepository = depulpingProcessRepository;
    }

    @Override
    public List<DepulpingProcess> findAll() {
        return depulpingProcessRepository.findAllByOrderByName();
    }

    @Override
    public DepulpingProcess findOne(Long id) {
        return depulpingProcessRepository.getOne(id);
    }

    @Override
    public DepulpingProcess save(DepulpingProcess depulpingProcess) {
        return depulpingProcessRepository.save(depulpingProcess);
    }

    @Override
    public void delete(Long id) {
        depulpingProcessRepository.deleteById(id);
    }

    @Override
    public List<Long> findDepulpingProcessesIds() {
        return depulpingProcessRepository.findDepulpingProcessesIds();
    }
}
