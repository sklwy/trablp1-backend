package com.heroku.ifeslp1backend.service;

import com.heroku.ifeslp1backend.model.Produto;
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
    public Produto insert(@Validated Produto produtos) {
        return produtosRepository.save(produtos);
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Produto> findList() {
        //Iteração de produtos
        List<Produto> listaProdutos = produtosRepository.findAll();
        Iterator<Produto> produtosIterator = listaProdutos.iterator();
        List<Produto> listaProdutosIterada = new ArrayList<>();
        while (produtosIterator.hasNext()) {
            Produto iterator = produtosIterator.next();
            listaProdutosIterada.add(iterator);
        }
        return listaProdutosIterada;
    }

    @Transactional(rollbackFor = Exception.class)
    public Optional<Produto> findById(Long proCod) {
        return produtosRepository.findById(proCod);
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Long proCod) {
        produtosRepository.delete(Objects.requireNonNull(findById(proCod).orElse(null)));
    }
}
