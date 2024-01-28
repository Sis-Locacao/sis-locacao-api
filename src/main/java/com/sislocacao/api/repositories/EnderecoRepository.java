package com.sislocacao.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sislocacao.api.model.entity.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
	Optional<Endereco> findByCepAndNumero(final String cep, final String numero);
}
