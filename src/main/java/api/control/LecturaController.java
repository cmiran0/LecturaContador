package api.control;

import api.jpa.ContadorRepo;
import api.jpa.LecturaRepo;
import api.model.Lectura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/controlGas/lectura")
public class LecturaController {
    @Autowired
    private LecturaRepo lecturaRepo;
    @Autowired
    private ContadorRepo contadorRepo;

    @PostMapping
    public void addLectura(@RequestBody Lectura lectura, @RequestParam String referencia_contador) {
        lectura.setContador(contadorRepo.findContadorByReferencia(referencia_contador));
        lecturaRepo.save(lectura);
    }

    @GetMapping
    public Iterable<Lectura> getLecturas() {
        return lecturaRepo.findAll();
    }

    @DeleteMapping("/{id}")
    public void delLectura(@PathVariable Long id) {
        if (lecturaRepo.findById(id).isPresent()) {
            lecturaRepo.deleteById(id);
        }
    }
}
