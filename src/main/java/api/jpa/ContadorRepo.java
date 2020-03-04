package api.jpa;

import api.model.Contador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContadorRepo extends CrudRepository<Contador,Long> {
    Contador findContadorByReferencia(String referencia);
}
