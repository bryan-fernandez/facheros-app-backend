package com.bichcon.pe.app.mapper;

import com.bichcon.pe.app.dto.RolDTO;
import com.bichcon.pe.app.entity.Rol;

public class RolMapper implements IRolMapper{
    @Override
    public RolDTO mapearDTO(Rol rol) {
        if (rol == null) return null;
        return new RolDTO(rol.getIdRol(), rol.getNombre());
    }

    @Override
    public Rol mapearEntidad(RolDTO rolDTO) {
        return new Rol(rolDTO.getCodigo(), rolDTO.getRol());
    }
}
