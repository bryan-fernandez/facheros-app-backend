package com.bichcon.pe.app.dto;

import com.bichcon.pe.app.values.Atencion;
import com.bichcon.pe.app.values.Estado;

import java.util.Date;
import java.util.List;

public class PedidoDTO {
    private Long codigo;
    private String cliente;
    private String nroOrden;
    private Double montoPedido;
    private Atencion atencion;
    private Estado estado;
    private Date fechaCreacion;
    private List<PlatilloDTO> platillos;

    public PedidoDTO() {
    }

    public PedidoDTO(Long codigo, String cliente, String nroOrden, Double montoPedido, Atencion atencion, Estado estado, Date fechaCreacion, List<PlatilloDTO> platillos) {
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

    public void setAtencion(Atencion antencion) {
        this.atencion = antencion;
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

    public List<PlatilloDTO> getPlatillos() {
        return platillos;
    }

    public void setPlatillos(List<PlatilloDTO> platillos) {
        this.platillos = platillos;
    }
}
