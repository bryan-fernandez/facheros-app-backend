package com.bichcon.pe.app.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class IPlatilloDAOTest {

    @Autowired
    private IPlatilloDAO platilloDao;

    @Test
    public void obtenerPlatillosTest() {

    }
}
