package com.sislocacao.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sislocacao.api.model.entity.Inquilino;

@Repository
public interface InquilinoRespository extends JpaRepository<Inquilino, Long>{

}
