package com.bichcon.pe.app.ui;

import com.bichcon.pe.app.dao.IPedidoDAO;
import com.bichcon.pe.app.dao.IPlatilloDAO;
import com.bichcon.pe.app.dao.IPlatilloPedidoDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PedidosPlatillos {

    @Autowired
    private IPlatilloPedidoDAO platilloPedidoDao;

    @Autowired
    private IPedidoDAO pedidoDao;

    @Autowired
    private IPlatilloDAO platilloDao;

    @Test
    public void asignarPlatillosAlPedido() {
        
    }
}
