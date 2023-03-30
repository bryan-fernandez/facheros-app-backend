package com.bichcon.pe.app.service;

import com.bichcon.pe.app.dao.IPlatilloPedidoDAO;
import com.bichcon.pe.app.dto.PlatilloPedidoDTO;
import com.bichcon.pe.app.entity.PlatilloPedido;
import com.bichcon.pe.app.mapper.PlatilloPedidoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlatilloPedidoServiceImp implements IPlatilloPedidoService {

    private final PlatilloPedidoMapper platilloPedidoMapper = new PlatilloPedidoMapper();

    @Autowired
    private IPlatilloPedidoDAO platilloPedidoDao;

    @Override
    public List<PlatilloPedidoDTO> obtenerDetallePedidos() {
        return platilloPedidoDao.findAll().stream().map(p -> platilloPedidoMapper.mapearDTO(p)).collect(Collectors.toList());
    }

    @Override
    public PlatilloPedidoDTO verDetallePedido(Long id) {
        return platilloPedidoMapper.mapearDTO(platilloPedidoDao.findById(id).get());
    }

    @Override
    public void guardarDetallePedido(PlatilloPedidoDTO platilloPedidoDTO) {
        platilloPedidoDao.save(platilloPedidoMapper.mapearEntitdad(platilloPedidoDTO));
    }

    @Override
    public void actualizarDetallePedido(PlatilloPedidoDTO platilloPedidoDTO) {
        platilloPedidoDao.saveAndFlush(platilloPedidoMapper.mapearEntitdad(platilloPedidoDTO));
    }

    @Override
    public void eliminarDetallePedido(Long id) {
        platilloPedidoDao.deleteById(id);
    }

    @Override
    public void guardarTodoDetallePedido(List<PlatilloPedidoDTO> detalles) {
        platilloPedidoDao.saveAll(detalles.stream().map(dp -> platilloPedidoMapper.mapearEntitdad(dp))
                .collect(Collectors.toList()));
    }
}
