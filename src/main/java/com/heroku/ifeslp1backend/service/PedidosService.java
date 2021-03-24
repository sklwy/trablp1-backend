package com.heroku.ifeslp1backend.service;

import com.heroku.ifeslp1backend.model.Pedidos;
import com.heroku.ifeslp1backend.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class PedidosService {

    @Autowired
    private PedidosRepository pedidosRepository;

    @Transactional(rollbackFor = Exception.class)
    public Pedidos insert(@Validated Pedidos pedidos) {
        return pedidosRepository.save(pedidos);
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Pedidos> findList() {
        List<Pedidos> listaPedidos = pedidosRepository.findAll();
        Iterator<Pedidos> pedidosIterator = listaPedidos.iterator();
        List<Pedidos> listaPedidosIterada = new ArrayList<>();
        while (pedidosIterator.hasNext()) {
            Pedidos iterator = pedidosIterator.next();
            listaPedidosIterada.add(iterator);
        }
        return listaPedidosIterada;
    }
}
