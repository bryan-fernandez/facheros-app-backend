package com.bichcon.pe.app.service;

import com.bichcon.pe.app.dto.PlatilloDTO;

import java.util.List;

public interface IPlatilloService {
    List<PlatilloDTO> obtenerPlatillos();
    PlatilloDTO verPlatillo(Long id);
    void guardarPlatillo(PlatilloDTO platilloDTO);
    void actualizarPlatillo(PlatilloDTO platilloDTO);
    void eliminarPlatillo(Long id);
}
