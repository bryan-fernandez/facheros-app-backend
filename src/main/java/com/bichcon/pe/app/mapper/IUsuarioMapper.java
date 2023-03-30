package com.bichcon.pe.app.mapper;

import com.bichcon.pe.app.dto.UsuarioDTO;
import com.bichcon.pe.app.entity.Usuario;

public interface IUsuarioMapper {
    UsuarioDTO mapearDTO(Usuario usuario);

    Usuario mapearEntidad(UsuarioDTO usuarioDTO);
}
