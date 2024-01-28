package com.sislocacao.api.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sislocacao.api.model.entity.Imovel;
import com.sislocacao.api.model.entity.Usuario;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel, Long>{

	List<Imovel> findAllByUsuario(Usuario usuario);
	
	Optional<Imovel> findByIdAndUsuario(Long id, Usuario usuario);
}
