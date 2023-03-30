package com.bichcon.pe.app.dto;

import com.bichcon.pe.app.values.Atencion;
import com.bichcon.pe.app.values.Estado;

import java.util.Date;
import java.util.List;

public class PedidoCustomDTO {
    private Long codigo;
    private String cliente;
    private String nroOrden;
    private Double montoPedido;
    private Atencion atencion;
    private Estado estado;
    private Date fechaCreacion;
    private List<PlatilloCustomDTO> platillos;

    public PedidoCustomDTO(){

    }

    public PedidoCustomDTO(Long codigo, String cliente, String nroOrden, Double montoPedido, Atencion atencion, Estado estado, Date fechaCreacion, List<PlatilloCustomDTO> platillos) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.nroOrden = nroOrden;
        this.montoPedido = montoPedido;
        this.atencion = atencion;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.platillos = platillos;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
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

    public Double getMontoPedido() {
        return montoPedido;
    }

    public void setMontoPedido(Double montoPedido) {
        this.montoPedido = montoPedido;
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

    public List<PlatilloCustomDTO> getPlatillos() {
        return platillos;
    }

    public void setPlatillos(List<PlatilloCustomDTO> platillos) {
        this.platillos = platillos;
    }
}
