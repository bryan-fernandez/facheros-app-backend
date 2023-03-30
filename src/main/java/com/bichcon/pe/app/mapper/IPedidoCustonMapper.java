package com.bichcon.pe.app.mapper;

import com.bichcon.pe.app.dto.PedidoCustomDTO;
import com.bichcon.pe.app.entity.Pedido;

public interface IPedidoCustonMapper {
    PedidoCustomDTO mapearDTO(Pedido pedido);
}
