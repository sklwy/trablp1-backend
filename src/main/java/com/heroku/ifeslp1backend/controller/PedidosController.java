package com.heroku.ifeslp1backend.controller;

import com.heroku.ifeslp1backend.enumerator.EPedStatus;
import com.heroku.ifeslp1backend.model.Pedidos;
import com.heroku.ifeslp1backend.service.PedidosService;
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
public class PedidosController {

    @Autowired
    private PedidosService pedidosService;

    @GetMapping(path = "/list")
    public ResponseEntity<List<Pedidos>> listPedidos() {
        return ResponseEntity.ok(pedidosService.findList());
    }

    @PostMapping(path = "/")
    public ResponseEntity<Pedidos> insert(@RequestBody Pedidos pedidos) {
        return new ResponseEntity<>(pedidosService.insert(pedidos), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{pedCod}")
    public ResponseEntity<Optional<Pedidos>> findById(@PathVariable Long pedCod) {
        return ResponseEntity.ok(pedidosService.findById(pedCod));
    }

    @PutMapping(path = "/cancelar")
    public ResponseEntity<Object> cancelarPedido(@RequestBody Pedidos pedidos) {
        Optional<Pedidos> registro = pedidosService.findById(pedidos.getPedCod());
        if (registro.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        pedidos.setPedStatus(EPedStatus.CANCELADO);
        pedidosService.update(pedidos);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(path = "/finalizar")
    public ResponseEntity<Object> finalizarPedido(@RequestBody Pedidos pedidos) {
        Optional<Pedidos> registro = pedidosService.findById(pedidos.getPedCod());
        if (registro.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        pedidos.setPedStatus(EPedStatus.FINALIZADO);
        pedidosService.insert(pedidos);
        return ResponseEntity.noContent().build();
    }
}
