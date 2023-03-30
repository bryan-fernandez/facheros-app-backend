package com.bichcon.pe.app.dao;

import com.bichcon.pe.app.entity.PlatilloPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPlatilloPedidoDAO extends JpaRepository<PlatilloPedido, Long> {
    @Query(name = "select * from platillos_pedido where id_pedido like :idpedido", nativeQuery = true)
    List<PlatilloPedido> findAllByIdPedido(@Param("idpedido") Long idpedido);

    @Query(name = "select * from platillos_pedido where id_pedido like :idpedido and id_platillo like :idplatillo", nativeQuery = true)
    PlatilloPedido findByIdPedidoAndIdPlatillo(@Param("idpedido") Long idpedido, @Param("idplatillo") Long idplatillo);
}
