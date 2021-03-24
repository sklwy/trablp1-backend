package com.heroku.ifeslp1backend.repository;

import com.heroku.ifeslp1backend.model.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidosRepository extends JpaRepository<Pedidos, Long> {
}
