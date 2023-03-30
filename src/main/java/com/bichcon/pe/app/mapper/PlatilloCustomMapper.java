package com.bichcon.pe.app.mapper;

import com.bichcon.pe.app.dao.IPlatilloPedidoDAO;
import com.bichcon.pe.app.dto.PlatilloCustomDTO;
import com.bichcon.pe.app.entity.Platillo;
import org.springframework.beans.factory.annotation.Autowired;

public class PlatilloCustomMapper implements IPlatilloCustomMapper{

    @Autowired
    private IPlatilloPedidoDAO platilloPedidoDao;

    @Override
    public PlatilloCustomDTO mapearDTO(Long idPedido, Platillo platillo) {
        if (platillo == null) return null;
        return new PlatilloCustomDTO(platillo.getIdPlatillo(), platillo.getDescripcion(), platillo.getPrecio(),
                null);
    }
}
