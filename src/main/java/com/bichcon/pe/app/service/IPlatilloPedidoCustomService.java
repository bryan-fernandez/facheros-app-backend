package com.bichcon.pe.app.service;

import com.bichcon.pe.app.entity.PlatilloPedido;

import java.util.List;

public interface IPlatilloPedidoCustomService {
    List<PlatilloPedido> obtenerPlatilloPedido(Long idPedido);
}
