package com.sislocacao.api.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sislocacao.api.domain.model.Usuario;
import com.sislocacao.api.domain.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario salvar(final Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
}
