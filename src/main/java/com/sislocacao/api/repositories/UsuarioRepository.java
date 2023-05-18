package com.sislocacao.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sislocacao.api.model.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	Optional<Usuario>findByRg(final String rg);
	Optional<Usuario>findByCpf(final String cpf);
	Optional<Usuario>findByEmail(final String email);
}
