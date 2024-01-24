package com.sislocacao.api.services.impl;

import org.springframework.stereotype.Service;

import com.sislocacao.api.mappers.InquilinoMapper;
import com.sislocacao.api.model.dto.InquilinoDTO;
import com.sislocacao.api.model.dto.InquilinoEntradaDTO;
import com.sislocacao.api.model.entity.Inquilino;
import com.sislocacao.api.model.entity.Usuario;
import com.sislocacao.api.repositories.InquilinoRespository;
import com.sislocacao.api.services.InquilinoService;
import com.sislocacao.api.services.UsuarioService;

@Service
public class InquilinoServiceImpl implements InquilinoService {

	private final InquilinoRespository inquilinoRespository;
	private final InquilinoMapper inquilinoMapper;
	private UsuarioService usuarioService;

	public InquilinoServiceImpl(final InquilinoRespository inquilinoRespository, final InquilinoMapper inquilinoMapper,
			final UsuarioServiceImpl usuarioServiceImpl) {
		this.inquilinoRespository = inquilinoRespository;
		this.inquilinoMapper = inquilinoMapper;
		this.usuarioService = usuarioServiceImpl;
	}

	@Override
	public InquilinoDTO salvarInquilino(InquilinoEntradaDTO inquilinoEntradaDTO) {
		Usuario usuario = usuarioService.validaUsuarioAutenticado();
		
		Inquilino inquilino = inquilinoRespository
				.save(inquilinoMapper.inquilinoDtoParaInquilinoEntidade(inquilinoEntradaDTO, usuario));
		return inquilinoMapper.inquilinoEntidadeParaInquilinoDto(inquilino);
	}

}
