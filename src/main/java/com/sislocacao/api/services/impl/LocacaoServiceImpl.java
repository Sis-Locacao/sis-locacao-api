package com.sislocacao.api.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sislocacao.api.exceptions.impl.ResourceNotFoundException;
import com.sislocacao.api.model.entity.Locacao;
import com.sislocacao.api.repositories.LocacaoRepository;
import com.sislocacao.api.services.LocacaoService;

@Service
public class LocacaoServiceImpl implements LocacaoService {

	@Autowired
	private LocacaoRepository locacaoRepository;

	@Override
	public Locacao buscarLocacaoPorId(Long id) {
		Locacao locacao = locacaoRepository.findById(id)
		.orElseThrow(() -> new ResourceNotFoundException("Locação não encontrada com o id: " + id));
		
		return locacaoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Locação não encontrada com o id: " + id));
	}

}
