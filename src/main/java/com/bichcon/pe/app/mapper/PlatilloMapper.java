package com.bichcon.pe.app.mapper;

import com.bichcon.pe.app.dto.PlatilloDTO;
import com.bichcon.pe.app.entity.Platillo;

public class PlatilloMapper implements IPlatilloMapper {

    @Override
    public PlatilloDTO mapearDTO(Platillo platillo) {
        if (platillo == null) return null;
        return new PlatilloDTO(platillo.getIdPlatillo(), platillo.getDescripcion(), platillo.getPrecio());
    }

    @Override
    public Platillo mapearEntidad(PlatilloDTO platilloDTO) {
        return new Platillo(platilloDTO.getCodigo(), platilloDTO.getPlatillo(), platilloDTO.getPrecio());
    }
}
