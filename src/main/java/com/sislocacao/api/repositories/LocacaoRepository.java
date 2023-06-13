package com.sislocacao.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sislocacao.api.model.entity.Locacao;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Long>{
}
