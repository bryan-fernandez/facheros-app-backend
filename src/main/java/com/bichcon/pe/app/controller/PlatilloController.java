package com.bichcon.pe.app.controller;

import com.bichcon.pe.app.dto.PlatilloDTO;
import com.bichcon.pe.app.service.IPlatilloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping(path = "/api/v1/platillo")
public class PlatilloController {

    @Autowired
    private IPlatilloService platilloService;

    @RequestMapping(path = "/listar", method = RequestMethod.GET)
    public ResponseEntity<?> obtenerPlatillos() {
        List<PlatilloDTO> platillos = platilloService.obtenerPlatillos();
        if (platillos.isEmpty()) return new ResponseEntity<>("No existen platillos guardados", HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(platillos);
    }

    @RequestMapping(path = "/obtener/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> obtenerPlatillo(@PathVariable Long id) {
        if (id == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        PlatilloDTO platilloDTO = platilloService.verPlatillo(id);
        if (platilloDTO == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(platilloDTO, HttpStatus.OK);
    }

    @RequestMapping(path = "/guardar", method = RequestMethod.POST)
    public ResponseEntity<?> guardarPlatillo(@RequestBody PlatilloDTO platilloDTO) {
        if (platilloDTO == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        platilloService.guardarPlatillo(platilloDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(path = "/actualizar", method = RequestMethod.PUT)
    public ResponseEntity<?> actualizarPlatillo(@RequestBody PlatilloDTO platilloDTO) {
        if (platilloDTO == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        PlatilloDTO platilloDb = platilloService.verPlatillo(platilloDTO.getCodigo());
        if (platilloDb == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        platilloService.actualizarPlatillo(platilloDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> eliminarPlatillo(@PathVariable Long id) {
        if (id == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        PlatilloDTO platilloDb = platilloService.verPlatillo(id);
        if (platilloDb == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        platilloService.eliminarPlatillo(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}