package com.heroku.ifeslp1backend.controller;

import com.heroku.ifeslp1backend.model.Mesa;
import com.heroku.ifeslp1backend.service.MesaService;
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
@RequestMapping("/api/mesas")
public class MesaController {

    @Autowired
    private MesaService mesaService;

    @GetMapping(path = "/list")
    public ResponseEntity<List<Mesa>> listMesas() {
        return ResponseEntity.ok(mesaService.findList());
    }

    @PostMapping(path = "/")
    public ResponseEntity<Mesa> insert(@RequestBody Mesa mesa) {
        return new ResponseEntity<>(mesaService.insert(mesa), HttpStatus.CREATED);
    }
}
