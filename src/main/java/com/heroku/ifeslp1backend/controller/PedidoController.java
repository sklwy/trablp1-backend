package com.heroku.ifeslp1backend.controller;

import com.heroku.ifeslp1backend.model.Pedido;
import com.heroku.ifeslp1backend.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidosService;

    @GetMapping(path = "/list")
    public ResponseEntity<List<Pedido>> listPedidos() {
        return ResponseEntity.ok(pedidosService.findList());
    }

    @PostMapping(path = "/")
    public ResponseEntity<Pedido> insert(@RequestBody Pedido pedido) {
        return new ResponseEntity<>(pedidosService.insert(pedido), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{pedCod}")
    public ResponseEntity<Optional<Pedido>> findById(@PathVariable Long codPedido) {
        return ResponseEntity.ok(pedidosService.findById(codPedido));
    }

    @PutMapping(path = "/{pedCod}/cancelar")
    public ResponseEntity<Void> cancelarPedido(@PathVariable Long codPedido, Pedido pedidoCan) {
        Optional<Pedido> registro = pedidosService.findById(codPedido);
        pedidoCan.setCodPedido(codPedido);
        if (registro.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        pedidosService.updateCancelado(codPedido, pedidoCan);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/{pedCod}/finalizar")
    public ResponseEntity<Void> finalizarPedido(@PathVariable Long codPedido, Pedido pedidoFin) {
        Optional<Pedido> registro = pedidosService.findById(codPedido);
        if (registro.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        pedidosService.updateFinalizado(codPedido, pedidoFin);
        return ResponseEntity.noContent().build();
    }
}
