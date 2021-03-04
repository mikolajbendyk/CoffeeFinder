package pl.bendyk.service;

import pl.bendyk.model.coffee.Method;

import java.util.List;

public interface MethodService {

    List<Method> findAll();
    Method findOne(Long id);
    Method save(Method method);
    void delete(Long id);

}
