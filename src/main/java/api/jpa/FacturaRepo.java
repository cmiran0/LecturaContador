package api.jpa;

import api.model.Factura;
import api.model.Lectura;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepo extends CrudRepository<Factura, Long> {
}
