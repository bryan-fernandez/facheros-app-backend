package com.bichcon.pe.app.mapper;

import com.bichcon.pe.app.dto.PlatilloPedidoDTO;
import com.bichcon.pe.app.entity.PlatilloPedido;

public class PlatilloPedidoMapper implements IPlatilloPedidoMapper {
    @Override
    public PlatilloPedidoDTO mapearDTO(PlatilloPedido platilloPedido) {
        return new PlatilloPedidoDTO(platilloPedido.getPlatillo().getIdPlatillo(), platilloPedido.getPedido().getId(),
                platilloPedido.getCantidad());
    }

    @Override
    public PlatilloPedido mapearEntitdad(PlatilloPedidoDTO platilloPedidoDTO) {
        return new PlatilloPedido(platilloPedidoDTO.getCodigoPlatillo(), platilloPedidoDTO.getNroPedido(),
                platilloPedidoDTO.getCantidad());
    }
}
