package com.heroku.ifeslp1backend.controller;

import com.heroku.ifeslp1backend.model.Produtos;
import com.heroku.ifeslp1backend.service.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/produtos")
public class ProdutosController {

    @Autowired
    private ProdutosService produtosService;

    @GetMapping(path = "/list")
    public ResponseEntity<List<Produtos>> listProdutos() {
        return ResponseEntity.ok(produtosService.findList());
    }

    @PostMapping(path = "/")
    public ResponseEntity<Produtos> insert(@RequestBody Produtos produtos) {
        return new ResponseEntity<>(produtosService.insert(produtos), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{proCod}")
    public ResponseEntity<Optional<Produtos>> findById(@PathVariable Long proCod) {
        return ResponseEntity.ok(produtosService.findById(proCod));
    }
}
