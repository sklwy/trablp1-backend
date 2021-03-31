package com.heroku.ifeslp1backend.controller;

import com.heroku.ifeslp1backend.model.Comanda;
import com.heroku.ifeslp1backend.service.ComandaService;
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
@RequestMapping("/api/comandas")
public class ComandaController {

    @Autowired
    private ComandaService comandasService;

    @GetMapping(path = "/list")
    public ResponseEntity<List<Comanda>> listComandas() {
        return ResponseEntity.ok(comandasService.findList());
    }

    @PostMapping(path = "/")
    public ResponseEntity<Comanda> insert(@RequestBody Comanda comanda) {
        return new ResponseEntity<>(comandasService.insert(comanda), HttpStatus.CREATED);
    }
}

