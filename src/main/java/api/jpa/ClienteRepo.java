package api.jpa;

import api.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepo extends CrudRepository<Cliente,Long> {
    Cliente findClienteByDni(String dni);
}
