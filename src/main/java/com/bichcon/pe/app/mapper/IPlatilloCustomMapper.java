package com.bichcon.pe.app.mapper;

import com.bichcon.pe.app.dto.PlatilloCustomDTO;
import com.bichcon.pe.app.entity.Platillo;

public interface IPlatilloCustomMapper {
    PlatilloCustomDTO mapearDTO(Long idPedido, Platillo platillo);
}
