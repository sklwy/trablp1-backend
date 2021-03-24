package com.heroku.ifeslp1backend.service;

import com.heroku.ifeslp1backend.enumerator.EPedStatus;
import com.heroku.ifeslp1backend.model.Comandas;
import com.heroku.ifeslp1backend.model.Pedidos;
import com.heroku.ifeslp1backend.repository.ComandasRepository;
import com.heroku.ifeslp1backend.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class PedidosService {

    @Autowired
    private PedidosRepository pedidosRepository;

    @Autowired
    private ComandasRepository comandasRepository;

    @Transactional(rollbackFor = Exception.class)
    public Pedidos insert(@Validated Pedidos pedidos) {
        if (pedidos.getComCod() == null) {
            Comandas comPedidos = new Comandas();
            pedidos.setComCod(comPedidos.getComCod());
        } else {
            Optional<Comandas> comandas = comandasRepository.findById(pedidos.getComCod());
            pedidos.setComCod(comandas.get().getComCod());
        }
        pedidos.setPedStatus(EPedStatus.ATIVO);
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

    @Transactional(rollbackFor = Exception.class)
    public Optional<Pedidos> findById(Long pedCod) {
        return pedidosRepository.findById(pedCod);
    }
}
