package com.bichcon.pe.app.dto;

import java.util.Set;

public class UsuarioDTO {
    private Long codigo;
    private String nombre;
    private String apellido;
    private String dni;
    private String celular;
    private String usuario;
    private String contrasenia;
    private Set<RolDTO> roles;

    public UsuarioDTO() {

    }

    public UsuarioDTO(Long codigo, String nombre, String apellido, String dni, String celular, String usuario, String contrasenia, Set<RolDTO> roles) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.celular = celular;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.roles = roles;
    }

    public UsuarioDTO(Long codigo, String nombre, String apellido, String dni, String celular, String usuario, Set<RolDTO> roles) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.celular = celular;
        this.usuario = usuario;
        this.roles = roles;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Set<RolDTO> getRoles() {
        return roles;
    }

    public void setRoles(Set<RolDTO> roles) {
        this.roles = roles;
    }
}
