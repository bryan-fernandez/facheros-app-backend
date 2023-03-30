package com.bichcon.pe.app.entity;

import javax.persistence.Column;
import java.io.Serializable;

public class PlatilloPedidoId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private Long idPlatillo;

    @Column(nullable = false)
    private Long idPedido;

    public PlatilloPedidoId(){

    }

    public PlatilloPedidoId(Long idPlatillo, Long idPedido) {
        this.idPlatillo = idPlatillo;
        this.idPedido = idPedido;
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
}
