package com.bichcon.pe.app.entity;

import com.bichcon.pe.app.values.Atencion;
import com.bichcon.pe.app.values.Estado;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cliente;
    private String nroOrden;
    private Double total;
    @Enumerated(EnumType.STRING)
    private Atencion atencion;
    @Enumerated(EnumType.STRING)
    private Estado estado;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd-MM-yyyy'T'HH:mm:ss")
    private Date fechaCreacion;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<PlatilloPedido> platilloPedidos = new ArrayList<>();
    @PrePersist
    private void prePresist() {
        fechaCreacion = new Date();
    }
    public Pedido(Long idPedido, String cliente, String nroOrden,Double total, Atencion atencion, Estado estado, Date fechaCreacion, List<PlatilloPedido> platilloPedidos) {
        this.id = idPedido;
        this.cliente = cliente;
        this.nroOrden = nroOrden;
        this.total = total;
        this.atencion = atencion;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.platilloPedidos = platilloPedidos;
    }

    public Pedido(String cliente, String nroOrden, Double total, Atencion atencion, Estado estado, List<PlatilloPedido> platilloPedidos) {
        this.cliente = cliente;
        this.nroOrden = nroOrden;
        this.total = total;
        this.atencion = atencion;
        this.estado = estado;
        this.platilloPedidos = platilloPedidos;
    }

    public Pedido(String cliente, String nroOrden, Double total, Atencion atencion, Estado estado) {
        this.cliente = cliente;
        this.nroOrden = nroOrden;
        this.total = total;
        this.atencion = atencion;
        this.estado = estado;
    }

    public Pedido() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getNroOrden() {
        return nroOrden;
    }

    public void setNroOrden(String nroOrden) {
        this.nroOrden = nroOrden;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Atencion getAtencion() {
        return atencion;
    }

    public void setAtencion(Atencion atencion) {
        this.atencion = atencion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public List<PlatilloPedido> getPlatilloPedidos() {
        return platilloPedidos;
    }

    public void setPlatilloPedidos(List<PlatilloPedido> platilloPedidos) {
        this.platilloPedidos = platilloPedidos;
    }
}
