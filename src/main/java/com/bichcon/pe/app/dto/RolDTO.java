package com.bichcon.pe.app.dto;

public class RolDTO {
    private Long codigo;
    private String rol;

    public RolDTO() {

    }

    public RolDTO(Long codigo, String rol) {
        this.codigo = codigo;
        this.rol = rol;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
