package com.sislocacao.api.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static Logger logger = LoggerFactory.getLogger(InquilinoServiceImpl.class);

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
		logger.info("[01] - Validando usuário autenticado");
		Usuario usuario = usuarioService.validaUsuarioAutenticado();
		
		logger.info("[02] - salva inquilino");
		Inquilino inquilino = inquilinoRespository
				.save(inquilinoMapper.inquilinoDtoParaInquilinoEntidade(inquilinoEntradaDTO, usuario));
		return inquilinoMapper.inquilinoEntidadeParaInquilinoDto(inquilino);
	}

	@Override
	public List<InquilinoDTO> listar() {
		logger.info("[01] - Validando usuário autenticado");
		Usuario usuario = usuarioService.validaUsuarioAutenticado();

		List<InquilinoDTO> listaInquilinoDto = new ArrayList<>();
		
		logger.info("[02] - Recupera todos os inquilinos");
		List<Inquilino> inquilinos = inquilinoRespository.findAllByUsuario(usuario);

		logger.info("[03] - Mappper de inquilinos");
		for (Inquilino inquilino : inquilinos) {
			listaInquilinoDto.add(inquilinoMapper.inquilinoEntidadeParaInquilinoDto(inquilino));
		}

		return listaInquilinoDto;
	}

	@Override
	public InquilinoDTO buscarPorId(Long id) {
		logger.info("[01] - Validando usuário autenticado");
		Usuario usuario = usuarioService.validaUsuarioAutenticado();
		
		logger.info("[02] - Recupera inquilino");
		Inquilino inquilino = inquilinoRespository.findByIdAndUsuario(id, usuario)
				.orElseThrow(() -> new ResourceNotFoundException("Inquilino não encontrado !"));
		
		logger.info("[03] - Mapeia e retorna inquilino");
		return inquilinoMapper.inquilinoEntidadeParaInquilinoDto(inquilino);
	}

	@Override
	public void delete(Long id) {
		logger.info("[01] - Validando usuário autenticado");
		Usuario usuario = usuarioService.validaUsuarioAutenticado();

		logger.info("[02] - Recupera inquilino");
		Inquilino inquilino = inquilinoRespository.findByIdAndUsuario(id, usuario)
				.orElseThrow(() -> new ResourceNotFoundException("Inquilino não encontrado !"));

		logger.info("[03] - Excluindo inquilino");
		inquilinoRespository.delete(inquilino);
	}

	@Override
	public InquilinoDTO atualizar(Long id, InquilinoEntradaDTO inquilinoDto) {
		logger.info("[01] - Validando usuário autenticado");
		Usuario usuario = usuarioService.validaUsuarioAutenticado();

		logger.info("[02] - Valida se inquilino existe");
		inquilinoRespository.findByIdAndUsuario(id, usuario)
				.orElseThrow(() -> new ResourceNotFoundException("Inquilino não encontrado !"));
		
		inquilinoDto.setId(id);
		
		logger.info("[03] - Mapper de inquilino e salva no banco");
		Inquilino inquilinoAtualizado = inquilinoRespository
				.save(inquilinoMapper.inquilinoDtoParaInquilinoEntidade(inquilinoDto, usuario));

		logger.info("[04] - Mapper de inquilino para retorno de endpoint");
		return inquilinoMapper.inquilinoEntidadeParaInquilinoDto(inquilinoAtualizado);
	}

}
