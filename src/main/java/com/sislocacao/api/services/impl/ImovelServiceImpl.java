package com.sislocacao.api.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.sislocacao.api.exceptions.impl.DataIntegrityViolationExceptionApp;
import com.sislocacao.api.exceptions.impl.ResourceNotFoundException;
import com.sislocacao.api.mappers.ImovelMapper;
import com.sislocacao.api.model.dto.ImovelDTO;
import com.sislocacao.api.model.dto.ImovelEntradaDTO;
import com.sislocacao.api.model.entity.Endereco;
import com.sislocacao.api.model.entity.Imovel;
import com.sislocacao.api.model.entity.Usuario;
import com.sislocacao.api.repositories.EnderecoRepository;
import com.sislocacao.api.repositories.ImovelRepository;
import com.sislocacao.api.services.ImovelService;
import com.sislocacao.api.services.UsuarioService;

@Service
public class ImovelServiceImpl implements ImovelService {
	private static Logger logger = LoggerFactory.getLogger(ImovelServiceImpl.class);

	private final ImovelRepository imovelRespository;
	private final ImovelMapper imovelMapper;
	private final UsuarioService usuarioService;
	private final EnderecoRepository enderecoRepository;

	public ImovelServiceImpl(final ImovelRepository imovelRespository, final ImovelMapper imovelMapper,
			final UsuarioServiceImpl usuarioServiceImpl, final EnderecoRepository enderecoRepository) {
		this.imovelRespository = imovelRespository;
		this.imovelMapper = imovelMapper;
		this.usuarioService = usuarioServiceImpl;
		this.enderecoRepository = enderecoRepository;
	}

	@Override
	public ImovelDTO salvar(ImovelEntradaDTO imovelEntradaDTO) {
		try {
			logger.info("[01] - Validando usuário autenticado");
			Usuario usuario = usuarioService.validaUsuarioAutenticado();

			logger.info("[02] - Verifica se o endereço já existe na base de dados");
			verificaAssociacaoEndereco(imovelEntradaDTO, usuario);

			logger.info("[03] - salva imovel");
			Imovel imovel = imovelRespository.save(imovelMapper.imovelDtoParaImovelEntidade(imovelEntradaDTO, usuario));
			return imovelMapper.imovelEntidadeParaImovelDto(imovel);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationExceptionApp("Erro de integridade de dados, duplicidade na base de dados");
		}
	}

	@Override
	public List<ImovelDTO> listar() {
		logger.info("[01] - Validando usuário autenticado");
		Usuario usuario = usuarioService.validaUsuarioAutenticado();

		List<ImovelDTO> listaImovelDto = new ArrayList<>();

		logger.info("[02] - Recupera todos os imoveis");
		List<Imovel> imoveis = imovelRespository.findAllByUsuario(usuario);

		logger.info("[03] - Mappper de imoveis");
		for (Imovel imovel : imoveis) {
			listaImovelDto.add(imovelMapper.imovelEntidadeParaImovelDto(imovel));
		}

		return listaImovelDto;
	}

	@Override
	public ImovelDTO buscarPorId(Long id) {
		logger.info("[01] - Validando usuário autenticado");
		Usuario usuario = usuarioService.validaUsuarioAutenticado();

		logger.info("[02] - Recupera imovel");
		Imovel imovel = imovelRespository.findByIdAndUsuario(id, usuario)
				.orElseThrow(() -> new ResourceNotFoundException("Imovel não encontrado !"));

		logger.info("[03] - Mapeia e retorna imovel");
		return imovelMapper.imovelEntidadeParaImovelDto(imovel);
	}

	@Override
	public void delete(Long id) {
		logger.info("[01] - Validando usuário autenticado");
		Usuario usuario = usuarioService.validaUsuarioAutenticado();

		logger.info("[02] - Recupera imovel");
		Imovel imovel = imovelRespository.findByIdAndUsuario(id, usuario)
				.orElseThrow(() -> new ResourceNotFoundException("Imovel não encontrado !"));

		logger.info("[03] - Excluindo imovel");
		imovelRespository.delete(imovel);
	}

	@Override
	public ImovelDTO atualizar(Long id, ImovelEntradaDTO imovelDto) {
		logger.info("[01] - Validando usuário autenticado");
		Usuario usuario = usuarioService.validaUsuarioAutenticado();

		logger.info("[02] - Valida se imovel existe");
		imovelRespository.findByIdAndUsuario(id, usuario)
				.orElseThrow(() -> new ResourceNotFoundException("Imovel não encontrado !"));

		imovelDto.setId(id);

		logger.info("[03] - Verifica se o endereço já existe na base de dados");
		verificaAssociacaoEndereco(imovelDto, usuario);

		logger.info("[04] - Mapper de imovel e salva no banco");
		Imovel imovelAtualizado = imovelRespository.save(imovelMapper.imovelDtoParaImovelEntidade(imovelDto, usuario));

		logger.info("[05] - Mapper de imovel para retorno de endpoint");
		return imovelMapper.imovelEntidadeParaImovelDto(imovelAtualizado);
	}

	private void verificaAssociacaoEndereco(ImovelEntradaDTO imovelDto, Usuario usuario) {
		Optional<Endereco> endereco = enderecoRepository.findByCepAndNumero(imovelDto.getEndereco().getCep(),
				imovelDto.getEndereco().getNumero());

		if (!endereco.isEmpty() && !Objects.equals(imovelDto.getEndereco().getId(), endereco.get().getId())) {
			throw new ResourceNotFoundException("Esse endereço já está associado a um imóvel");
		}
	}

}
