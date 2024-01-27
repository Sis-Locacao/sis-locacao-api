package com.sislocacao.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sislocacao.api.model.entity.Inquilino;
import com.sislocacao.api.model.entity.Usuario;

@Repository
public interface InquilinoRespository extends JpaRepository<Inquilino, Long>{

	List<Inquilino> findAllByUsuario(Usuario usuario);
}
