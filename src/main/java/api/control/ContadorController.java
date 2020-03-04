package api.control;

import api.jpa.ClienteRepo;
import api.jpa.ContadorRepo;
import api.model.Cliente;
import api.model.Contador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/controlGas/contador")
public class ContadorController {
    @Autowired
    private ContadorRepo contadorRepo;
    @Autowired
    private ClienteRepo clienteRepo;

    @PostMapping
    public void addContador(@RequestBody Contador contador, @RequestParam String dni_cliente) {

        contador.setCliente(clienteRepo.findClienteByDni(dni_cliente));
        contadorRepo.save(contador);

    }

    @GetMapping
    public Iterable<Contador> getComptadors() {
        return contadorRepo.findAll();
    }


}
