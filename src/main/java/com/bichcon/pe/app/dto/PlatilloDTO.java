package com.bichcon.pe.app.dto;

public class PlatilloDTO {
    private Long codigo;
    private String platillo;
    private Double precio;

    public PlatilloDTO() {

    }

    public PlatilloDTO(Long codigo, String platillo, Double precio) {
        this.codigo = codigo;
        this.platillo = platillo;
        this.precio = precio;
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
}
