package com.bichcon.pe.app.dao;

import com.bichcon.pe.app.entity.Platillo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlatilloDAO extends JpaRepository<Platillo, Long> {
    Platillo findByDescripcion(String descripcion);
}
