package api.jpa;

import api.model.Lectura;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LecturaRepo extends CrudRepository<Lectura, Long> {
}
