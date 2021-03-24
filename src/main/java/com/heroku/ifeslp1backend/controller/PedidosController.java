package com.heroku.ifeslp1backend.controller;

import com.heroku.ifeslp1backend.model.Pedidos;
import com.heroku.ifeslp1backend.service.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
