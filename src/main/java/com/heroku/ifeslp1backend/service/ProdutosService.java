package com.heroku.ifeslp1backend.service;

import com.heroku.ifeslp1backend.model.Produtos;
import com.heroku.ifeslp1backend.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProdutosService {

    @Autowired
    private ProdutosRepository produtosRepository;

    @Transactional(rollbackFor = Exception.class)
    public Produtos insert(@Validated Produtos produtos) {
        return produtosRepository.save(produtos);
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Produtos> findList() {
        //Iteração de produtos
        List<Produtos> listaProdutos = produtosRepository.findAll();
        Iterator<Produtos> produtosIterator = listaProdutos.iterator();
        List<Produtos> listaProdutosIterada = new ArrayList<>();
        while (produtosIterator.hasNext()) {
            Produtos iterator = produtosIterator.next();
            listaProdutosIterada.add(iterator);
        }
        return listaProdutosIterada;
    }

    @Transactional(rollbackFor = Exception.class)
    public Optional<Produtos> findById(Long proCod) {
        return produtosRepository.findById(proCod);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Long proCod) {
        produtosRepository.delete(Objects.requireNonNull(findById(proCod).orElse(null)));
    }
}
