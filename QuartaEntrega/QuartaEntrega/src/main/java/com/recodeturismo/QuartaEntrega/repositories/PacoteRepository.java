package com.recodeturismo.QuartaEntrega.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recodeturismo.QuartaEntrega.model.Pacote;

@Repository
public interface PacoteRepository extends JpaRepository<Pacote, Long> {

}
