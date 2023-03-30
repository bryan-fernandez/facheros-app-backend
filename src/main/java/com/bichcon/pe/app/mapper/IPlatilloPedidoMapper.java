package com.bichcon.pe.app.mapper;

import com.bichcon.pe.app.dto.PlatilloPedidoDTO;
import com.bichcon.pe.app.entity.PlatilloPedido;

public interface IPlatilloPedidoMapper {
    PlatilloPedidoDTO mapearDTO(PlatilloPedido platilloPedido);

    PlatilloPedido mapearEntitdad(PlatilloPedidoDTO platilloPedidoDTO);
}
