package com.bichcon.pe.app.service;

import com.bichcon.pe.app.dao.IPlatilloDAO;
import com.bichcon.pe.app.dao.IPlatilloPedidoDAO;
import com.bichcon.pe.app.dto.PlatilloCustomDTO;
import com.bichcon.pe.app.dto.PlatilloDTO;
import com.bichcon.pe.app.entity.Platillo;
import com.bichcon.pe.app.entity.PlatilloPedido;
import com.bichcon.pe.app.mapper.PlatilloCustomMapper;
import com.bichcon.pe.app.mapper.PlatilloMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlatilloCustomServiceImp implements IPlatilloCustomService {

    private final PlatilloCustomMapper platilloCustomMapper = new PlatilloCustomMapper();
    private final PlatilloMapper platilloMapper = new PlatilloMapper();

    @Autowired
    private IPlatilloPedidoDAO platilloPedidoDao;

    @Autowired
    private IPlatilloDAO platilloDao;

    @Override
    public List<PlatilloDTO> obtenerPlatillos(Long idPedido) {
        List<PlatilloDTO> platillos = new ArrayList<>();

        //Obteniendo identificadores de todos los platillos para un pedido
        List<PlatilloPedido> platillosDelPedido = platilloPedidoDao.findAllByIdPedido(idPedido);

        for (PlatilloPedido p : platillosDelPedido) {
            Platillo platillo = platilloDao.findById(p.getIdPlatillo()).get();
            platillos.add(platilloMapper.mapearDTO(platillo));
        }

        return platillos;
    }

    @Override
    public List<PlatilloCustomDTO> obtenerPlatillosCustom(Long idPedido) {

        List<PlatilloCustomDTO> platillos = new ArrayList<>();

        //Obteniendo identificadores de todos los platillos para un pedido
        List<PlatilloPedido> platillosDelPedido = platilloPedidoDao.findAllByIdPedido(idPedido);

        for (PlatilloPedido p : platillosDelPedido) {
            Platillo platillo = platilloDao.findById(p.getIdPlatillo()).get();

            //Obtener platillo pedido para extraer la cantidad pedida
            PlatilloPedido platilloPedido = platilloPedidoDao.findByIdPedidoAndIdPlatillo(idPedido, platillo.getIdPlatillo());

            PlatilloCustomDTO platilloCustomDTO = platilloCustomMapper.mapearDTO(idPedido, platillo);
            platilloCustomDTO.setCantidad(platilloPedido.getCantidad());
            platillos.add(platilloCustomDTO);
        }

        return platillos;
    }
}
