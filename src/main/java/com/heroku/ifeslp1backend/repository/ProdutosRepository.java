package com.heroku.ifeslp1backend.repository;

import com.heroku.ifeslp1backend.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutosRepository extends JpaRepository<Produto, Long> {
}
