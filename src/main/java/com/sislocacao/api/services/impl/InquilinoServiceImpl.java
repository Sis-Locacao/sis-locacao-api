package com.sislocacao.api.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sislocacao.api.exceptions.impl.ResourceNotFoundException;
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
	public InquilinoDTO salvar(InquilinoEntradaDTO inquilinoEntradaDTO) {
		Usuario usuario = usuarioService.validaUsuarioAutenticado();

		Inquilino inquilino = inquilinoRespository
				.save(inquilinoMapper.inquilinoDtoParaInquilinoEntidade(inquilinoEntradaDTO, usuario));
		return inquilinoMapper.inquilinoEntidadeParaInquilinoDto(inquilino);
	}

	@Override
	public List<InquilinoDTO> listar() {
		Usuario usuario = usuarioService.validaUsuarioAutenticado();

		List<InquilinoDTO> listaInquilinoDto = new ArrayList<>();

		List<Inquilino> inquilinos = inquilinoRespository.findAllByUsuario(usuario);

		for (Inquilino inquilino : inquilinos) {
			listaInquilinoDto.add(inquilinoMapper.inquilinoEntidadeParaInquilinoDto(inquilino));
		}

		return listaInquilinoDto;
	}

	@Override
	public InquilinoDTO buscarPorId(Long id) {
		Usuario usuario = usuarioService.validaUsuarioAutenticado();

		Inquilino inquilino = inquilinoRespository.findByIdAndUsuario(id, usuario)
				.orElseThrow(() -> new ResourceNotFoundException("Inquilino não encontrado !"));

		return inquilinoMapper.inquilinoEntidadeParaInquilinoDto(inquilino);
	}

	@Override
	public void delete(Long id) {
		Usuario usuario = usuarioService.validaUsuarioAutenticado();

		Inquilino inquilino = inquilinoRespository.findByIdAndUsuario(id, usuario)
				.orElseThrow(() -> new ResourceNotFoundException("Inquilino não encontrado !"));

		inquilinoRespository.delete(inquilino);
	}

	@Override
	public InquilinoDTO atualizar(Long id, InquilinoEntradaDTO inquilinoDto) {
		Usuario usuario = usuarioService.validaUsuarioAutenticado();

		inquilinoRespository.findByIdAndUsuario(id, usuario)
				.orElseThrow(() -> new ResourceNotFoundException("Inquilino não encontrado !"));
		
		inquilinoDto.setId(id);
		
		Inquilino inquilinoAtualizado = inquilinoRespository
				.save(inquilinoMapper.inquilinoDtoParaInquilinoEntidade(inquilinoDto, usuario));

		return inquilinoMapper.inquilinoEntidadeParaInquilinoDto(inquilinoAtualizado);
	}

}
