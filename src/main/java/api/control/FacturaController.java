package api.control;

import api.jpa.ContadorRepo;
import api.jpa.FacturaRepo;
import api.jpa.LecturaRepo;
import api.model.Contador;
import api.model.Factura;
import api.model.Lectura;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(path = "/controlGas/factura")
public class FacturaController {
    private static final Logger log = (Logger) LoggerFactory.getLogger(FacturaController.class);
    @Autowired
    private FacturaRepo facturaRepo;
    @Autowired
    private LecturaRepo lecturaRepo;
    @Autowired
    private ContadorRepo contadorRepo;

    @GetMapping
    public Iterable<Factura> getFacturas() {
        return facturaRepo.findAll();
    }

    @GetMapping("/{estado}")
    public List<Lectura> getFacturasPagadas(@PathVariable boolean estado) {
        return lecturaRepo.findAllByFacturada(estado);
    }

    @GetMapping("/pruebas")
    public List<Lectura> pruebas(@RequestParam String referencia) {
        Contador contador = contadorRepo.findContadorByReferencia(referencia);
        Long idContador = contador.getId_contador();
        List<Lectura> listaLecturas = new ArrayList<>();
        for (Lectura lectura : listaLecturas) {
            if (idContador == lectura.getContador().getId_contador()) listaLecturas.add(lectura);
        }
        int lecturainicial, lecturaFinal, consumo;
        return listaLecturas;
    }

    public void calculaFacturasPrueba() {
        String referencia = "1111A";
        Contador contador = contadorRepo.findContadorByReferencia(referencia);
        Long idContador = contador.getId_contador();
        List<Lectura> listalecturas = new ArrayList<>();
        listalecturas = lecturaRepo.findAllByFacturada(false);
        int valor = 0;
        for (int i = 0; i <listalecturas.size() ; i++) {
            if (idContador == listalecturas.get(i).getContador().getId_contador()){
                valor = listalecturas.get(i).getValor_lectura();
            }
        }
        log.info("LECTURA: " + valor);
    }

}
