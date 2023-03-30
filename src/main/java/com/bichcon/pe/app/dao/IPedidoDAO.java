package com.bichcon.pe.app.dao;

import com.bichcon.pe.app.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPedidoDAO extends JpaRepository<Pedido, Long> {
}
