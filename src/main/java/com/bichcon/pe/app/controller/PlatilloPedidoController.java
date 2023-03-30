package com.bichcon.pe.app.controller;

import com.bichcon.pe.app.dto.PlatilloPedidoDTO;
import com.bichcon.pe.app.service.IPlatilloPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/platilloPedido")
public class PlatilloPedidoController {

    @Autowired
    private IPlatilloPedidoService platilloPedidoService;

    @RequestMapping(path = "/listar", method = RequestMethod.GET)
    public ResponseEntity<?> obtenerDetallePedidos() {
        return ResponseEntity.ok(platilloPedidoService.obtenerDetallePedidos());
    }

    @RequestMapping(path = "/ver/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> verDetallePedido(@PathVariable Long id) {
        if (id == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        PlatilloPedidoDTO platilloPedidoDb = platilloPedidoService.verDetallePedido(id);
        if (platilloPedidoDb == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(platilloPedidoDb, HttpStatus.OK);
    }

    @RequestMapping(path = "/guardar", method = RequestMethod.POST)
    public ResponseEntity<?> guardarDetallePedido(@RequestBody PlatilloPedidoDTO platilloPedidoDTO) {
        if (platilloPedidoDTO == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        platilloPedidoService.guardarDetallePedido(platilloPedidoDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(path = "/guardarTodo", method = RequestMethod.POST)
    public ResponseEntity<?> guardarTodoDetallePedido(@RequestBody List<PlatilloPedidoDTO> platilloPedidoDTO) {
        if (platilloPedidoDTO == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        platilloPedidoService.guardarTodoDetallePedido(platilloPedidoDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(path = "/actualizar", method = RequestMethod.PUT)
    public ResponseEntity<?> actualizarPedido(@RequestBody PlatilloPedidoDTO platilloPedidoDTO) {
        if (platilloPedidoDTO == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        PlatilloPedidoDTO platilloPedidoDb = platilloPedidoService.verDetallePedido(platilloPedidoDTO.getCodigoPlatillo());
        if (platilloPedidoDb == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        platilloPedidoService.actualizarDetallePedido(platilloPedidoDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> eliminaraDetallePedido(@PathVariable Long id) {
        if (id == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        PlatilloPedidoDTO platilloPedidoDb = platilloPedidoService.verDetallePedido(id);
        if (platilloPedidoDb == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        platilloPedidoService.eliminarDetallePedido(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
