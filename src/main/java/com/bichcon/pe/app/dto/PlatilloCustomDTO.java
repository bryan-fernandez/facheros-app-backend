package com.bichcon.pe.app.dto;

public class PlatilloCustomDTO {
    private Long codigo;
    private String platillo;
    private Double precio;
    private Integer cantidad;

    public PlatilloCustomDTO() {
    }

    public PlatilloCustomDTO(Long codigo, String platillo, Double precio, Integer cantidad) {
        this.codigo = codigo;
        this.platillo = platillo;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getPlatillo() {
        return platillo;
    }

    public void setPlatillo(String platillo) {
        this.platillo = platillo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
