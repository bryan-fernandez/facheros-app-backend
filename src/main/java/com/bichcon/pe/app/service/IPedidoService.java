package com.bichcon.pe.app.service;

import com.bichcon.pe.app.dto.PedidoCustomDTO;
import com.bichcon.pe.app.dto.PedidoDTO;
import com.bichcon.pe.app.values.Estado;

import java.util.List;

public interface IPedidoService {
    List<PedidoDTO> obtenerPedidos();

    PedidoDTO verPedido(Long id);

    PedidoDTO guardarPedido(PedidoDTO pedidoDTO);

    void actualizarPedido(PedidoDTO pedidoDTO);

    void eliminarPedido(Long id);

    List<PedidoCustomDTO> obtenerPedidosCustom();

    void actualizarEstadoPedido(Long idPedido, Estado estado);
}
