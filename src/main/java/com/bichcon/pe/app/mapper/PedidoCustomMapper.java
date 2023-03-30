package com.bichcon.pe.app.mapper;

import com.bichcon.pe.app.dto.PedidoCustomDTO;
import com.bichcon.pe.app.entity.Pedido;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class PedidoCustomMapper implements IPedidoCustonMapper{

    @Override
    public PedidoCustomDTO mapearDTO(Pedido pedido) {
        return new PedidoCustomDTO(pedido.getId(), pedido.getCliente(), pedido.getNroOrden(),pedido.getTotal(), pedido.getAtencion(),pedido.getEstado(),
                pedido.getFechaCreacion(), new ArrayList<>()); //obtenerPlatillosCustom(pedido.getIdPedido())
    }
}
