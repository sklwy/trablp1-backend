package com.heroku.ifeslp1backend.repository;

import com.heroku.ifeslp1backend.model.Comandas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComandasRepository extends JpaRepository<Comandas, Long> {
}
