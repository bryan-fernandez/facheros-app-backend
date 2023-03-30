package com.bichcon.pe.app.controller;

import com.bichcon.pe.app.dto.PedidoDTO;
import com.bichcon.pe.app.service.IPedidoService;
import com.bichcon.pe.app.values.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/pedido")
public class PedidoController {

    @Autowired
    private IPedidoService pedidoService;

    @RequestMapping(path = "/listar", method = RequestMethod.GET)
    public ResponseEntity<?> obtenerPedidos() {
        return ResponseEntity.ok(pedidoService.obtenerPedidos());
    }

    @RequestMapping(path = "/listarCustom", method = RequestMethod.GET)
    public ResponseEntity<?> obtenerPedidosCustom() {
        return ResponseEntity.ok(pedidoService.obtenerPedidosCustom());
    }

    @RequestMapping(path = "/ver/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> verPedido(@PathVariable Long id) {
        if (id == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        PedidoDTO pedidoDb = pedidoService.verPedido(id);
        if (pedidoDb == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(pedidoDb, HttpStatus.OK);
    }

    @RequestMapping(path = "/guardar", method = RequestMethod.POST)
    public ResponseEntity<?> guardarPedido(@RequestBody PedidoDTO pedidoDTO) {
        if (pedidoDTO == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(pedidoService.guardarPedido(pedidoDTO), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/actualizar", method = RequestMethod.PUT)
    public ResponseEntity<?> actualizarPedido(@RequestBody PedidoDTO pedidoDTO) {
        if (pedidoDTO == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        PedidoDTO pedidoDb = pedidoService.verPedido(pedidoDTO.getCodigo());
        if (pedidoDb == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        pedidoService.actualizarPedido(pedidoDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> eliminarPedido(@PathVariable Long id) {
        if (id == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        PedidoDTO pedidoDb = pedidoService.verPedido(id);
        if (pedidoDb == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        pedidoService.eliminarPedido(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(path = "/actualizar/estado/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> actualizarEstado(@PathVariable Long id, @RequestParam(value = "estado", defaultValue = "", required = true) Estado estado) {
        if (id == null || estado == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        pedidoService.actualizarEstadoPedido(id, estado);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
