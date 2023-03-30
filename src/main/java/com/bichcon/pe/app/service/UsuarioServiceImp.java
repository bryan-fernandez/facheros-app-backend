package com.bichcon.pe.app.service;

import com.bichcon.pe.app.dao.IUsuarioDAO;
import com.bichcon.pe.app.dto.UsuarioDTO;
import com.bichcon.pe.app.mapper.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImp implements IUsuarioService {

    private final UsuarioMapper usuarioMapper = new UsuarioMapper();

    @Autowired
    private IUsuarioDAO usuarioDao;

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioDTO> obtenerUsuarios() {
        return usuarioDao.findAll().stream().map(u -> usuarioMapper.mapearDTO(u)).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public UsuarioDTO verUsuario(Long id) {
        return usuarioMapper.mapearDTO(usuarioDao.findById(id).orElse(null));
    }

    @Override
    @Transactional
    public void guardarUsuario(UsuarioDTO usuarioDTO) {
        usuarioDao.save(usuarioMapper.mapearEntidad(usuarioDTO));
    }

    @Override
    @Transactional
    public void actualizarUsuario(UsuarioDTO usuarioDTO) {
        usuarioDao.saveAndFlush(usuarioMapper.mapearEntidad(usuarioDTO));
    }

    @Override
    @Transactional
    public void eliminarUsuario(Long id) {
        usuarioDao.deleteById(id);
    }
}