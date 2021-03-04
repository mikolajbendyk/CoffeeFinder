package pl.bendyk.service;

import pl.bendyk.model.coffee.DepulpingProcess;

import java.util.List;

public interface DepulpingProcessService {

    List<DepulpingProcess> findAll();
    DepulpingProcess findOne(Long id);
    DepulpingProcess save(DepulpingProcess depulpingProcess);
    void delete(Long id);

}
