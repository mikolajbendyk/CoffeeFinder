package pl.bendyk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bendyk.model.coffee.Method;

import java.util.List;
import java.util.Optional;

@Repository
public interface MethodRepository extends JpaRepository<Method, Long> {

    List<Method> findAllByOrderByName();
    Method save(Method method);
    void deleteById(Long id);

}
