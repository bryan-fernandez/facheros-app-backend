package com.bichcon.pe.app.service;

import com.bichcon.pe.app.dto.PlatilloCustomDTO;
import com.bichcon.pe.app.dto.PlatilloDTO;

import java.util.List;

public interface IPlatilloCustomService {
    List<PlatilloDTO> obtenerPlatillos(Long idPedido);

    List<PlatilloCustomDTO> obtenerPlatillosCustom(Long idPedido);
}
