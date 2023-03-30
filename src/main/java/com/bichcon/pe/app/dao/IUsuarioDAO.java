package com.bichcon.pe.app.dao;

import com.bichcon.pe.app.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioDAO extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
}
