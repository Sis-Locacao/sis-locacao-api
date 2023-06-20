package com.sislocacao.api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sislocacao.api.exceptions.impl.ResourceNotFoundException;
import com.sislocacao.api.mappers.LocacaoMapper;
import com.sislocacao.api.model.dto.LocacaoDTO;
import com.sislocacao.api.model.entity.Locacao;
import com.sislocacao.api.model.entity.Usuario;
import com.sislocacao.api.repositories.LocacaoRepository;
import com.sislocacao.api.services.LocacaoService;
import com.sislocacao.api.services.UsuarioService;

@Service
public class LocacaoServiceImpl implements LocacaoService {

	@Autowired
	private LocacaoRepository locacaoRepository;

	@Autowired
	private LocacaoMapper locacaoMapper;
	
	@Autowired
	private UsuarioService usuarioService;

	@Override
	public LocacaoDTO buscarLocacaoPorId(Long id) {
		// valida usuario autenticado
		Usuario user = usuarioService.validaUsuarioAutenticado();

		Locacao locacao = locacaoRepository.findByIdAndUsuario(id, user)
				.orElseThrow(() -> new ResourceNotFoundException("Locação não encontrada com o id: " + id));

		return locacaoMapper.locacaoEntidadaParaLocacaoSaidaDto(locacao);
	}

}
