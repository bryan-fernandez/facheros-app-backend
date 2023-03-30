package com.bichcon.pe.app.service;

import com.bichcon.pe.app.dao.IPlatilloDAO;
import com.bichcon.pe.app.dto.PlatilloDTO;
import com.bichcon.pe.app.mapper.PlatilloMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlatilloServiceImp implements IPlatilloService {

    private final PlatilloMapper platilloMapper = new PlatilloMapper();

    @Autowired
    private IPlatilloDAO platilloDao;

    public PlatilloServiceImp() {
    }

    @Override
    public List<PlatilloDTO> obtenerPlatillos() {
        return platilloDao.findAll().stream().map(p -> platilloMapper.mapearDTO(p)).collect(Collectors.toList());
    }

    @Override
    public PlatilloDTO verPlatillo(Long id) {
        return platilloMapper.mapearDTO(platilloDao.findById(id).orElse(null));
    }

    @Override
    public void guardarPlatillo(PlatilloDTO platilloDTO) {
        platilloDao.save(platilloMapper.mapearEntidad(platilloDTO));
    }

    @Override
    public void actualizarPlatillo(PlatilloDTO platilloDTO) {
        platilloDao.saveAndFlush(platilloMapper.mapearEntidad(platilloDTO));
    }

    @Override
    public void eliminarPlatillo(Long id) {
        platilloDao.deleteById(id);
    }
}
