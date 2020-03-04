package api.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Contador implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_contador;

    private String referencia, direccion, poblacion, cp;

    @ManyToOne(targetEntity = Cliente.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "dni_id_cliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "contador", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Lectura.class)
    private List<Lectura> lecturas = new ArrayList<>();

    public Contador() {
    }

    public Long getId_contador() {
        return id_contador;
    }

    public void setId_contador(Long id_contador) {
        this.id_contador = id_contador;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
