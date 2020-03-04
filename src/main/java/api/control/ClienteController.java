package api.control;

import api.jpa.ClienteRepo;
import api.model.Cliente;
import api.model.Contador;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/controlGas/cliente")
public class ClienteController {
    @Autowired
    private ClienteRepo clienteRepo;

    @PostMapping
    public void addClient(@RequestBody Cliente client) {
        clienteRepo.save(client);
    }

    @GetMapping
    public Iterable<Cliente> getClientes() {
        return clienteRepo.findAll();
    }

    @PutMapping("/{id}")
    public Cliente updateClient(@RequestBody Cliente client, @PathVariable Long id) {
        if (clienteRepo.existsById(id)) {
            client.setId_cliente(id);
            return clienteRepo.save(client);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{dni_cliente}")
    public void delContador(@PathVariable String dni_cliente) {
        clienteRepo.delete(clienteRepo.findClienteByDni(dni_cliente));
    }


}
