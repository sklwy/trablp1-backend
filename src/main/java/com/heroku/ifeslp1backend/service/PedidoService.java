package com.heroku.ifeslp1backend.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.heroku.ifeslp1backend.enumerator.EPedStatus;
import com.heroku.ifeslp1backend.model.Comanda;
import com.heroku.ifeslp1backend.model.Pedido;
import com.heroku.ifeslp1backend.model.Produto;
import com.heroku.ifeslp1backend.repository.ComandaRepository;
import com.heroku.ifeslp1backend.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private ComandaRepository comandaRepository;

	@Transactional(rollbackFor = Exception.class)
	public Pedido insert(@Validated Pedido pedidos) {
		// Validação para criação de comandas
		if (pedidos.getCodComanda() == null) {
			Comanda novaComanda = new Comanda();
			comandaRepository.save(novaComanda);
			pedidos.setCodComanda(novaComanda.getCodComanda());
			novaComanda.setListPedidos(Collections.singletonList(pedidos));
		} else {
			// Iteração de pedidos
			Optional<Comanda> comandas = comandaRepository.findById(pedidos.getCodComanda());
			List<Pedido> listaPedidos = comandas.get().getListPedidos();
			Iterator<Pedido> pedidosIterator = listaPedidos.iterator();
			List<Pedido> listaPedidosIterada = new ArrayList<>();
			pedidoRepository.save(pedidos);
			listaPedidosIterada.add(pedidos);
			while (pedidosIterator.hasNext()) {
				Pedido iterator = pedidosIterator.next();
				listaPedidosIterada.add(iterator);
			}
			comandas.get().setListPedidos(listaPedidosIterada);
			double valor = 0;
			for (int i = 0; i < listaPedidosIterada.size(); i++) {
				List<Produto> produtos = (listaPedidosIterada.get(i).getProdutos());
				for (int k = 0; k < produtos.size(); k++) {
					valor += produtos.get(k).getProValor();
				}
				produtos.get(i).setProValor(valor);
			}

		}
		pedidos.setStatusPedidos(EPedStatus.ATIVO);
		return pedidoRepository.save(pedidos);
	}

	@Transactional(rollbackFor = Exception.class)
	public List<Pedido> findList() {
		// Iteração de todos os itens da lista
		List<Pedido> listaPedidos = pedidoRepository.findAll();
		Iterator<Pedido> pedidosIterator = listaPedidos.iterator();
		List<Pedido> listaPedidosIterada = new ArrayList<>();
		while (pedidosIterator.hasNext()) {
			Pedido iterator = pedidosIterator.next();
			listaPedidosIterada.add(iterator);
		}
		return listaPedidosIterada;
	}

	@Transactional(rollbackFor = Exception.class)
	public Optional<Pedido> findById(Long pedCod) {
		return pedidoRepository.findById(pedCod);
	}

	@Transactional(rollbackFor = Exception.class)
	public void updateCancelado(Long pedCod, @Validated Pedido pedidos) {
		// Procura pelo chave primaria, se existir ele faz o set pra cancelado
		Optional<Pedido> registro = pedidoRepository.findById(pedidos.getCodPedido());
		if (registro.isPresent()) {
			Pedido pedido = registro.get();
			pedido.setStatusPedidos(EPedStatus.CANCELADO);
			this.pedidoRepository.save(pedido);
		}
	}

	@Transactional(rollbackFor = Exception.class)
	public void updateFinalizado(Long pedCod, @Validated Pedido pedidos) {
		// Procura pelo chave primaria, se existir ele faz o set pra finalizado
		Optional<Pedido> registro = pedidoRepository.findById(pedidos.getCodPedido());
		if (registro.isPresent()) {
			Pedido pedido = registro.get();
			// Se o registro estiver cancelado não faz nada
			if (pedido.getStatusPedidos().equals(EPedStatus.CANCELADO)) {
			} else {
				pedido.setStatusPedidos(EPedStatus.FINALIZADO);
				this.pedidoRepository.save(pedido);
			}
		}
	}
}
