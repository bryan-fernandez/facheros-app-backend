package com.bichcon.pe.app.service;

import com.bichcon.pe.app.dao.IPedidoDAO;
import com.bichcon.pe.app.dao.IPlatilloDAO;
import com.bichcon.pe.app.dao.IPlatilloPedidoDAO;
import com.bichcon.pe.app.dto.*;
import com.bichcon.pe.app.entity.Pedido;
import com.bichcon.pe.app.entity.PlatilloPedido;
import com.bichcon.pe.app.mapper.PedidoCustomMapper;
import com.bichcon.pe.app.mapper.PedidoMapper;
import com.bichcon.pe.app.values.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImp implements IPedidoService {

    private final PedidoMapper pedidoMapper = new PedidoMapper();
    private final PedidoCustomMapper pedidoCustomMapper = new PedidoCustomMapper();

    @Autowired
    private IPedidoDAO pedidoDao;

    @Autowired
    private IPlatilloDAO platilloDao;

    @Autowired
    private IPlatilloPedidoDAO platilloPedidoDao;

    @Autowired
    private IPlatilloCustomService platilloCustomService;

    @Override
    public List<PedidoDTO> obtenerPedidos() {
        return pedidoDao.findAll().stream().map(p -> {
            PedidoDTO pedido = pedidoMapper.mapearDTO(p);
            pedido.setPlatillos(platilloCustomService.obtenerPlatillos(pedido.getCodigo()));
            return pedido;
        }).collect(Collectors.toList());
    }

    @Override
    public PedidoDTO verPedido(Long id) {
        PedidoDTO pedido = pedidoMapper.mapearDTO(pedidoDao.findById(id).orElse(null));
        if (pedido == null) return null;
        pedido.setPlatillos(platilloCustomService.obtenerPlatillos(id));
        return pedido;
    }

    @Override
    public PedidoDTO guardarPedido(PedidoDTO pedidoDTO) {
        Pedido pedido = pedidoMapper.mapearEntidad(pedidoDTO);
        pedido.setPlatilloPedidos(obtenerPlatilloPedido(pedidoDTO.getCodigo()));
        return pedidoMapper.mapearDTO(pedidoDao.save(pedido));
    }

    @Override
    public void actualizarPedido(PedidoDTO pedidoDTO) {
        Pedido pedido = pedidoMapper.mapearEntidad(pedidoDTO);
        pedido.setPlatilloPedidos(obtenerPlatilloPedido(pedidoDTO.getCodigo()));
        pedidoDao.saveAndFlush(pedido);
    }

    @Override
    public void eliminarPedido(Long id) {
        pedidoDao.deleteById(id);
    }

    @Override
    public List<PedidoCustomDTO> obtenerPedidosCustom() {
        return pedidoDao.findAll().stream().map(p -> {
            PedidoCustomDTO pedidoCustomDTO = pedidoCustomMapper.mapearDTO(p);
            pedidoCustomDTO.setPlatillos(platilloCustomService.obtenerPlatillosCustom(p.getId()));
            return pedidoCustomDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public void actualizarEstadoPedido(Long idPedido, Estado estado) {
        Pedido pedidoDb = pedidoDao.findById(idPedido).orElse(null);
        if(pedidoDb != null) {
            pedidoDb.setEstado(estado);
            pedidoDao.saveAndFlush(pedidoDb);
        }
    }

    public List<PlatilloPedido> obtenerPlatilloPedido(Long idPedido) {
        return platilloPedidoDao.findAllByIdPedido(idPedido);
    }
}