package api.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Lectura implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_lectura;
    final private LocalDateTime fecha;
    private int valor_lectura;
    private boolean facturada;

    @ManyToOne(targetEntity = Contador.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ref_id_contador")
    private Contador contador;

    public Lectura() {
        fecha = LocalDateTime.now();
    }

    public Long getId_lectura() {
        return id_lectura;
    }

    public void setId_lectura(Long id_lectura) {
        this.id_lectura = id_lectura;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public int getValor_lectura() {
        return valor_lectura;
    }

    public void setValor_lectura(int valor_lectura) {
        this.valor_lectura = valor_lectura;
    }

    public Contador getContador() {
        return contador;
    }

    public void setContador(Contador contador) {
        this.contador = contador;
    }

    public boolean isFacturada() {
        return facturada;
    }

    public void setFacturada(boolean facturada) {
        this.facturada = facturada;
    }
}
