package com.bichcon.pe.app.service;

import com.bichcon.pe.app.dto.UsuarioDTO;

import java.util.List;

public interface IUsuarioService {
    List<UsuarioDTO> obtenerUsuarios();

    UsuarioDTO verUsuario(Long id);

    void guardarUsuario(UsuarioDTO usuarioDTO);

    void actualizarUsuario(UsuarioDTO usuarioDTO);

    void eliminarUsuario(Long id);
}
