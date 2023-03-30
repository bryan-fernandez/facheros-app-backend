package com.bichcon.pe.app.mapper;

import com.bichcon.pe.app.dto.PlatilloDTO;
import com.bichcon.pe.app.entity.Platillo;

public interface IPlatilloMapper {
    PlatilloDTO mapearDTO(Platillo platillo);

    Platillo mapearEntidad(PlatilloDTO platilloDTO);
}
