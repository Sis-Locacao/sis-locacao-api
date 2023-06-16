package com.sislocacao.api.services;

import com.sislocacao.api.model.dto.UsuarioEntradaDTO;
import com.sislocacao.api.model.dto.UsuarioSaidaDTO;
import com.sislocacao.api.model.entity.Usuario;

public interface UsuarioService {
	/**
	 * Salva um novo usuário com base nos dados fornecidos no objeto UsuarioEntradaDTO.
	 *
	 * @param usuarioEntradaDTO O objeto UsuarioEntradaDTO contendo os dados do usuário a ser salvo.
	 * @return Um objeto UsuarioSaidaDTO representando o usuário salvo.
	 */
	public UsuarioSaidaDTO salvar(final UsuarioEntradaDTO usuarioEntradaDTO);
	
	public Usuario validaUsuarioAutenticado();
}
