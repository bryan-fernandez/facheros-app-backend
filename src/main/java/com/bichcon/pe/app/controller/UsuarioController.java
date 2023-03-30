package com.bichcon.pe.app.controller;

import com.bichcon.pe.app.dto.UsuarioDTO;
import com.bichcon.pe.app.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/usuario")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @RequestMapping(path = "/listar", method = RequestMethod.GET)
    public ResponseEntity<?> obtenerUsuarios() {
        List<UsuarioDTO> usuarios = usuarioService.obtenerUsuarios();

        if (usuarios.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(usuarios);
    }

    @RequestMapping(path = "/obtener/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> verUsuario(@PathVariable Long id) {
        if (id == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        UsuarioDTO usuarioDb = usuarioService.verUsuario(id);
        if (usuarioDb == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(usuarioDb, HttpStatus.OK);
    }

    @RequestMapping(path = "/guardar", method = RequestMethod.POST)
    public ResponseEntity<?> guardarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        if (usuarioDTO == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        usuarioService.guardarUsuario(usuarioDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(path = "/actualizar", method = RequestMethod.PUT)
    public ResponseEntity<?> actualizarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        if (usuarioDTO == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        UsuarioDTO usuarioDb = usuarioService.verUsuario(usuarioDTO.getCodigo());
        if (usuarioDb == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        usuarioService.actualizarUsuario(usuarioDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> eliminarUsuario(@PathVariable Long id) {
        if (id == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        UsuarioDTO usuarioDb = usuarioService.verUsuario(id);
        if (usuarioDb == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        usuarioService.eliminarUsuario(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}