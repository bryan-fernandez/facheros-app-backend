package com.bichcon.pe.app.mapper;

import com.bichcon.pe.app.dto.RolDTO;
import com.bichcon.pe.app.entity.Rol;

public interface IRolMapper {
    RolDTO mapearDTO(Rol rol);

    Rol mapearEntidad(RolDTO rolDTO);
}
