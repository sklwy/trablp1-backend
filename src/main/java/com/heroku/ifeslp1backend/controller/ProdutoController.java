package com.heroku.ifeslp1backend.controller;

import com.heroku.ifeslp1backend.model.Produto;
import com.heroku.ifeslp1backend.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
public class ProdutoController {

    @Autowired
    private ProdutoService produtosService;

    @GetMapping(path = "/list")
    public ResponseEntity<List<Produto>> listProdutos() {
        return ResponseEntity.ok(produtosService.findList());
    }

    @PostMapping(path = "/")
    public ResponseEntity<Produto> insert(@RequestBody Produto produtos) {
        return new ResponseEntity<>(produtosService.insert(produtos), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{proCod}")
    public ResponseEntity<Optional<Produto>> findById(@PathVariable Long proCod) {
        return ResponseEntity.ok(produtosService.findById(proCod));
    }

    @DeleteMapping(path = "/{proCod}")
    public ResponseEntity<Void> delete(@PathVariable Long proCod) {
        produtosService.delete(proCod);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
