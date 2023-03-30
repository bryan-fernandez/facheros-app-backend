package com.bichcon.pe.app.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "platillos_pedido")
@IdClass(PlatilloPedidoId.class)
public class PlatilloPedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long idPlatillo;

    @Id
    private Long idPedido;

    @Column(name = "cantidad")
    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "idPlatillo", referencedColumnName = "id", insertable = false, updatable = false)
    private Platillo platillo;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "idPedido", referencedColumnName = "id", insertable = false, updatable = false)
    private Pedido pedido;

    public PlatilloPedido() {

    }

    public PlatilloPedido(Long idPlatillo, Long idPedido, Integer cantidad, Platillo platillo, Pedido pedido) {
        this.idPlatillo = idPlatillo;
        this.idPedido = idPedido;
        this.cantidad = cantidad;
        this.platillo = platillo;
        this.pedido = pedido;
    }

    public PlatilloPedido(Long idPedido, Integer cantidad, Platillo platillo, Pedido pedido) {
        this.idPedido = idPedido;
        this.cantidad = cantidad;
        this.platillo = platillo;
        this.pedido = pedido;
    }

    public PlatilloPedido(Long idPlatillo, Long idPedido, Integer cantidad) {
        this.idPlatillo = idPlatillo;
        this.idPedido = idPedido;
        this.cantidad = cantidad;
    }

    public Long getIdPlatillo() {
        return idPlatillo;
    }

    public void setIdPlatillo(Long idPlatillo) {
        this.idPlatillo = idPlatillo;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Platillo getPlatillo() {
        return platillo;
    }

    public void setPlatillo(Platillo platillo) {
        this.platillo = platillo;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

//    @Override
//    public String toString() {
//        return "PlatilloPedido{" +
//                "idPlatillo=" + idPlatillo +
//                ", idPedido=" + idPedido +
//                ", cantidad=" + cantidad +
//                ", platillo=" + platillo +
//                ", pedido=" + pedido +
//                '}';
//    }
}
