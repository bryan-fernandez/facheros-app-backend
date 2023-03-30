package com.bichcon.pe.app.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "platillos")
public class Platillo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    private Double precio;

    @OneToMany(mappedBy = "platillo")
    private List<PlatilloPedido> platilloPedidos = new ArrayList<>();

    public Platillo() {
    }

    public Platillo(Long idPlatillo, String descripcion, Double precio) {
        this.id = idPlatillo;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public Long getIdPlatillo() {
        return id;
    }

    public void setIdPlatillo(Long idPlatillo) {
        this.id = idPlatillo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Platillo{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", platilloPedidos=" + platilloPedidos +
                '}';
    }
}
