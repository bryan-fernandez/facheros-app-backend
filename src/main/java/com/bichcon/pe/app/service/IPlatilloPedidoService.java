package com.bichcon.pe.app.service;

import com.bichcon.pe.app.dto.PlatilloPedidoDTO;

import java.util.List;

public interface IPlatilloPedidoService {
    List<PlatilloPedidoDTO> obtenerDetallePedidos();

    PlatilloPedidoDTO verDetallePedido(Long id);

    void guardarDetallePedido(PlatilloPedidoDTO platilloPedidoDTO);

    void actualizarDetallePedido(PlatilloPedidoDTO platilloPedidoDTO);

    void eliminarDetallePedido(Long id);

    void guardarTodoDetallePedido(List<PlatilloPedidoDTO> detalles);
}
