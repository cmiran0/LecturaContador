package api.jpa;

import api.model.Lectura;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LecturaRepo extends CrudRepository<Lectura, Long> {
    List<Lectura> findAllByFacturada(boolean facturado);
}
