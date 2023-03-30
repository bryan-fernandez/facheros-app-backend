package com.bichcon.pe.app.mapper;

import com.bichcon.pe.app.dto.PedidoDTO;
import com.bichcon.pe.app.entity.Pedido;

public interface IPedidoMapper {
    PedidoDTO mapearDTO(Pedido pedido);

    Pedido mapearEntidad(PedidoDTO pedidoDTO);
}
