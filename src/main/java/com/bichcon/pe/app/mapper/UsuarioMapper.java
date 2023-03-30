package com.bichcon.pe.app.mapper;

import com.bichcon.pe.app.dto.UsuarioDTO;
import com.bichcon.pe.app.entity.Usuario;

import java.util.stream.Collectors;

public class UsuarioMapper implements IUsuarioMapper{

    private final RolMapper rolMapper = new RolMapper();

    @Override
    public UsuarioDTO mapearDTO(Usuario usuario) {
        if (usuario == null) return null;
        return new UsuarioDTO(usuario.getIdUsuario(), usuario.getNombre(), usuario.getApellido(), usuario.getDni(),
                usuario.getCelular(), usuario.getEmail(), usuario.getContrasenia(),
                usuario.getRoles().stream().map(r -> rolMapper.mapearDTO(r)).collect(Collectors.toSet()));
    }

    @Override
    public Usuario mapearEntidad(UsuarioDTO usuarioDTO) {
        return new Usuario(usuarioDTO.getCodigo(), usuarioDTO.getNombre(), usuarioDTO.getApellido(), usuarioDTO.getDni(),
                usuarioDTO.getCelular(), usuarioDTO.getUsuario(), usuarioDTO.getContrasenia(),
                usuarioDTO.getRoles().stream().map(rolDTO -> rolMapper.mapearEntidad(rolDTO)).collect(Collectors.toSet()));
    }
}
