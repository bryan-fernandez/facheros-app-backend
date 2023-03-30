package com.bichcon.pe.app.mapper;

import com.bichcon.pe.app.dto.PedidoDTO;
import com.bichcon.pe.app.entity.Pedido;

import java.util.ArrayList;

public class PedidoMapper implements IPedidoMapper{

    private final PlatilloMapper platilloMapper = new PlatilloMapper();

    @Override
    public PedidoDTO mapearDTO(Pedido pedido) {
        return new PedidoDTO(pedido.getId(), pedido.getCliente(), pedido.getNroOrden(), pedido.getTotal(), pedido.getAtencion(),pedido.getEstado(),
                pedido.getFechaCreacion(), new ArrayList<>()); //obtenerPlatillos(pedido.getIdPedido())
    }

    @Override
    public Pedido mapearEntidad(PedidoDTO pedidoDTO) {
        return new Pedido(pedidoDTO.getCodigo(), pedidoDTO.getCliente(), pedidoDTO.getNroOrden(),pedidoDTO.getMontoPedido(),
                pedidoDTO.getAtencion(), pedidoDTO.getEstado(), pedidoDTO.getFechaCreacion(),
                new ArrayList<>()); //obtenerPlatilloPedido(pedidoDTO.getCodigo())
    }
}
