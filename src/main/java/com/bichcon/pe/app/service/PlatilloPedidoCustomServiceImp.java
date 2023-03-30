package com.bichcon.pe.app.service;

import com.bichcon.pe.app.dao.IPlatilloPedidoDAO;
import com.bichcon.pe.app.entity.PlatilloPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatilloPedidoCustomServiceImp implements IPlatilloPedidoCustomService{

    @Autowired
    private IPlatilloPedidoDAO platilloPedidoDao;

    @Override
    public List<PlatilloPedido> obtenerPlatilloPedido(Long idPedido) {
        return platilloPedidoDao.findAllByIdPedido(idPedido);
    }
}
