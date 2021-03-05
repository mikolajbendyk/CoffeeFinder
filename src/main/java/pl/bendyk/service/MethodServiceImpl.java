package pl.bendyk.service;

import org.springframework.stereotype.Service;
import pl.bendyk.model.coffee.Method;
import pl.bendyk.repository.MethodRepository;

import java.util.List;

@Service
public class MethodServiceImpl implements MethodService {

    private final MethodRepository methodRepository;

    public MethodServiceImpl(MethodRepository methodRepository) {
        this.methodRepository = methodRepository;
    }

    @Override
    public List<Method> findAll() {
        return methodRepository.findAllByOrderByName();
    }

    @Override
    public Method findOne(Long id) {
        return methodRepository.getOne(id);
    }

    @Override
    public Method save(Method method) {
        return methodRepository.save(method);
    }

    @Override
    public void delete(Long id) {
        methodRepository.deleteById(id);
    }

    @Override
    public List<Long> findMethodsIds() {
        return methodRepository.findMethodsIds();
    }
}
