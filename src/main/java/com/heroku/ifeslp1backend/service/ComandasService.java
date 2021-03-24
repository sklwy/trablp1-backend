package com.heroku.ifeslp1backend.service;

import com.heroku.ifeslp1backend.model.Comandas;
import com.heroku.ifeslp1backend.repository.ComandasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ComandasService {

    @Autowired
    private ComandasRepository comandasRepository;

    @Transactional(rollbackFor = Exception.class)
    public Comandas insert(@Validated Comandas comandas) {
        return comandasRepository.save(comandas);
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Comandas> findList() {
        List<Comandas> listaComandas = comandasRepository.findAll();
        Iterator<Comandas> comandasIterator = listaComandas.iterator();
        List<Comandas> listaMesasIterada = new ArrayList<>();
        while (comandasIterator.hasNext()) {
            Comandas iterator = comandasIterator.next();
            listaMesasIterada.add(iterator);
        }
        return listaMesasIterada;
    }
}
