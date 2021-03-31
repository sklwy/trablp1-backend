package com.heroku.ifeslp1backend.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.heroku.ifeslp1backend.model.Comanda;
import com.heroku.ifeslp1backend.repository.ComandaRepository;

@Service
public class ComandaService {

	@Autowired
	private ComandaRepository comandaRepository;

	@Transactional(rollbackFor = Exception.class)
	public Comanda insert(@Validated Comanda comandas) {
		return comandaRepository.save(comandas);
	}

	@Transactional(rollbackFor = Exception.class)
	public List<Comanda> findList() {
		// Iteração de comandas
		List<Comanda> listaComandas = comandaRepository.findAll();
		Iterator<Comanda> comandasIterator = listaComandas.iterator();
		List<Comanda> listaMesasIterada = new ArrayList<>();
		while (comandasIterator.hasNext()) {
			Comanda iterator = comandasIterator.next();
			listaMesasIterada.add(iterator);
		}
		return listaMesasIterada;
	}
}
