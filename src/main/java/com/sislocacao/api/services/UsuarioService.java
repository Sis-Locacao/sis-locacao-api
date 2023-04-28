package com.sislocacao.api.services;

import com.sislocacao.api.model.dto.UsuarioEntradaDTO;
import com.sislocacao.api.model.dto.UsuarioSaidaDTO;

public interface UsuarioService {
	public UsuarioSaidaDTO salvar(final UsuarioEntradaDTO usuarioEntradaDTO);
}
