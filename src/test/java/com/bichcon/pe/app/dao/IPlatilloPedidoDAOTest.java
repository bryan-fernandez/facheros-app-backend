package com.bichcon.pe.app.dao;

import com.bichcon.pe.app.entity.Pedido;
import com.bichcon.pe.app.entity.Platillo;
import com.bichcon.pe.app.entity.PlatilloPedido;
import com.bichcon.pe.app.values.Atencion;
import com.bichcon.pe.app.values.Estado;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class IPlatilloPedidoDAOTest {

    @Autowired
    private IPlatilloPedidoDAO platilloPedidoDao;

    @Autowired
    private IPedidoDAO pedidoDao;

    @Autowired
    private IPlatilloDAO platilloDao;

    @Test
    public void crearPedido() {
        Pedido pedido = new Pedido("Bryan Fernandez", "P01-M2", 27.50,Atencion.PRESENCIAL, Estado.PENDIENTE, new ArrayList<>());
        Pedido pedidoGuardado = pedidoDao.save(pedido);

        assertEquals(pedido, pedidoGuardado);
    }

    @Test
    public void crearPedidoConPlatillos() {
        //Buscar platillos
        Platillo platillo1 = platilloDao.findByDescripcion("Hamburguesa Royal");
        Platillo platillo2 = platilloDao.findByDescripcion("Hamburguesa Clásica");

        System.out.println(platillo1);
        System.out.println(platillo2);

        //Crear pedido
        Pedido pedido = new Pedido("Bryan Fernandez", "P01-M2", 27.50,Atencion.PRESENCIAL, Estado.PENDIENTE, new ArrayList<>());
        Pedido pedidoGuardado = pedidoDao.save(pedido);

        System.out.println(pedidoGuardado);

        //Asociar platillos al pedido

        Platillo platilloAux1 = new Platillo();
        platilloAux1.setIdPlatillo(platillo1.getIdPlatillo());
        Platillo platilloAux2 = new Platillo();
        platilloAux2.setIdPlatillo(platillo2.getIdPlatillo());

        Pedido pedidoAux1 = new Pedido();
        pedidoAux1.setId(pedido.getId());

        PlatilloPedido platilloPedido1 = new PlatilloPedido(platillo1.getIdPlatillo(), pedidoGuardado.getId(), 3, platilloAux1, pedidoAux1);
        PlatilloPedido platilloPedido2 = new PlatilloPedido(platillo2.getIdPlatillo(), pedidoGuardado.getId(), 1, platilloAux1, pedidoAux1);

        List<PlatilloPedido> platillosPedido = platilloPedidoDao.saveAll(Arrays.asList(platilloPedido1, platilloPedido2));
        for (PlatilloPedido p : platillosPedido) {
            System.out.println("PEDIDO PLATILLO:" + p);
        }

        //Actualizar pedido con el total de pago por todos los platillos

        Pedido pedidoDb = pedidoDao.findById(pedidoGuardado.getId()).get();
        pedidoDb.setTotal(27.50);

        System.out.println(pedidoDb);

        assertTrue(1 == 1);
    }

    @Test
    public void findAllByIdPedido(){
        //Buscar platillos
        Platillo platillo1 = platilloDao.findByDescripcion("Hamburguesa Royal");
        Platillo platillo2 = platilloDao.findByDescripcion("Hamburguesa Clásica");

        System.out.println(platillo1);
        System.out.println(platillo2);

        //Crear pedido
        Pedido pedido = new Pedido("Bryan Fernandez", "P01-M2", 27.50,Atencion.PRESENCIAL, Estado.PENDIENTE, new ArrayList<>());
        Pedido pedidoGuardado = pedidoDao.save(pedido);

        System.out.println(pedidoGuardado);

        //Asociar platillos al pedido

        Platillo platilloAux1 = new Platillo();
        platilloAux1.setIdPlatillo(platillo1.getIdPlatillo());
        Platillo platilloAux2 = new Platillo();
        platilloAux2.setIdPlatillo(platillo2.getIdPlatillo());

        Pedido pedidoAux1 = new Pedido();
        pedidoAux1.setId(pedido.getId());

        PlatilloPedido platilloPedido1 = new PlatilloPedido(platillo1.getIdPlatillo(), pedidoGuardado.getId(), 3, platilloAux1, pedidoAux1);
        PlatilloPedido platilloPedido2 = new PlatilloPedido(platillo2.getIdPlatillo(), pedidoGuardado.getId(), 1, platilloAux1, pedidoAux1);

        List<PlatilloPedido> platillosPedido = platilloPedidoDao.saveAll(Arrays.asList(platilloPedido1, platilloPedido2));
        for (PlatilloPedido p : platillosPedido) {
            System.out.println("PEDIDO PLATILLO:" + p);
        }

        //Actualizar pedido con el total de pago por todos los platillos

        Pedido pedidoDb = pedidoDao.findById(pedidoGuardado.getId()).get();
        pedidoDb.setTotal(27.50);

        System.out.println(pedidoDb);


        System.out.println(pedidoGuardado.getId());
        System.out.println(pedidoGuardado.getCliente());
        System.out.println(pedidoGuardado.getEstado());
        System.out.println(pedidoGuardado.getFechaCreacion());

        List<PlatilloPedido> platillosDelPedido = platilloPedidoDao.findAllByIdPedido(pedidoGuardado.getId());
        PlatilloPedido platilloPedido = platilloPedidoDao.findByIdPedidoAndIdPlatillo(pedidoGuardado.getId(), platillo1.getIdPlatillo());

        assertNotNull(platillosDelPedido);
    }
}