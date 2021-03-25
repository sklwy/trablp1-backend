package com.heroku.ifeslp1backend.service;

import com.heroku.ifeslp1backend.model.Mesa;
import com.heroku.ifeslp1backend.repository.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class MesaService {

    @Autowired
    private MesaRepository mesaRepository;

    @Transactional(rollbackFor = Exception.class)
    public Mesa insert(@Validated Mesa mesa) {
        return mesaRepository.save(mesa);
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Mesa> findList() {
        //Iteração de mesas
        List<Mesa> listaMesas = mesaRepository.findAll();
        Iterator<Mesa> mesasIterator = listaMesas.iterator();
        List<Mesa> listaMesasIterada = new ArrayList<>();
        while (mesasIterator.hasNext()) {
            Mesa iterator = mesasIterator.next();
            listaMesasIterada.add(iterator);
        }
        return listaMesasIterada;
    }
}
