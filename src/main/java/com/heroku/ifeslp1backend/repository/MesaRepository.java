package com.heroku.ifeslp1backend.repository;

import com.heroku.ifeslp1backend.model.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Long> {
}
