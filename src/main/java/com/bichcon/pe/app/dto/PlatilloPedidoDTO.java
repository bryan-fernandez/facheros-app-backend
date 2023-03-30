package com.bichcon.pe.app.dto;

public class PlatilloPedidoDTO {
    private Long codigoPlatillo;
    private Long nroPedido;
    private Integer cantidad;

    public PlatilloPedidoDTO() {
    }

    public Long getCodigoPlatillo() {
        return codigoPlatillo;
    }

    public void setCodigoPlatillo(Long codigoPlatillo) {
        this.codigoPlatillo = codigoPlatillo;
    }

    public Long getNroPedido() {
        return nroPedido;
    }

    public void setNroPedido(Long nroPedido) {
        this.nroPedido = nroPedido;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public PlatilloPedidoDTO(Long codigoPlatillo, Long nroPedido, Integer cantidad) {
        this.codigoPlatillo = codigoPlatillo;
        this.nroPedido = nroPedido;
        this.cantidad = cantidad;
    }
}
