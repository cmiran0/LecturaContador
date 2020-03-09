package api.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Factura implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int lecturaInicial, lecturaFinal, consumo;
    private double importe;
    private LocalDateTime fechaEmision;
    @ManyToOne(targetEntity = Cliente.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @ManyToOne(targetEntity = Contador.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "contador_id")
    private Contador contador;

    public Contador getContador() {
        return contador;
    }

    public void setContador(Contador contador) {
        this.contador = contador;
    }

    public Factura() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getLecturaInicial() {
        return lecturaInicial;
    }

    public void setLecturaInicial(int lecturaInicial) {
        this.lecturaInicial = lecturaInicial;
    }

    public int getLecturaFinal() {
        return lecturaFinal;
    }

    public void setLecturaFinal(int lecturaFinal) {
        this.lecturaFinal = lecturaFinal;
    }

    public int getConsumo() {
        return consumo;
    }

    public void setConsumo(int consumo) {
        this.consumo = consumo;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public LocalDateTime getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDateTime fechaEmision) {
        this.fechaEmision = fechaEmision;
    }
}
