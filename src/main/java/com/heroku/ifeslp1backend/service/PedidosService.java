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

import java.util.*;

@Service
public class PedidosService {

    @Autowired
    private PedidosRepository pedidosRepository;

    @Autowired
    private ComandasRepository comandasRepository;

    @Transactional(rollbackFor = Exception.class)
    public Pedidos insert(@Validated Pedidos pedidos) {
        if (pedidos.getComCod() == null) {
            Comandas novaComanda = new Comandas();
            comandasRepository.save(novaComanda);
            pedidos.setComCod(novaComanda.getComCod());
            novaComanda.setComPedidos(Collections.singletonList(pedidos));
        } else {
            Optional<Comandas> comandas = comandasRepository.findById(pedidos.getComCod());
            List<Pedidos> listaPedidos = comandas.get().getComPedidos();
            Iterator<Pedidos> pedidosIterator = listaPedidos.iterator();
            List<Pedidos> listaPedidosIterada = new ArrayList<>();
            pedidosRepository.save(pedidos);
            listaPedidosIterada.add(pedidos);
            while (pedidosIterator.hasNext()) {
                Pedidos iterator = pedidosIterator.next();
                listaPedidosIterada.add(iterator);
            }
            comandas.get().setComPedidos(listaPedidosIterada);
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

    @Transactional(rollbackFor = Exception.class)
    public void updateCancelado(Long pedCod, @Validated Pedidos pedidos) {
        Optional<Pedidos> registro = pedidosRepository.findById(pedidos.getPedCod());
        if (registro.isPresent()) {
            Pedidos pedido = registro.get();
            pedido.setPedStatus(EPedStatus.CANCELADO);
            pedido.setPedIsCancelado(true);
            this.pedidosRepository.save(pedido);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateFinalizado(Long pedCod, @Validated Pedidos pedidos) {
        Optional<Pedidos> registro = pedidosRepository.findById(pedidos.getPedCod());
        if (registro.isPresent()) {
            Pedidos pedido = registro.get();
            pedido.setPedStatus(EPedStatus.FINALIZADO);
            this.pedidosRepository.save(pedido);
        }
    }
}
