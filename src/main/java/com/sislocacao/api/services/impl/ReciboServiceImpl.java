package com.sislocacao.api.services.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sislocacao.api.exceptions.impl.ResourceNotFoundException;
import com.sislocacao.api.mappers.ReciboMapper;
import com.sislocacao.api.model.dto.ReciboEntradaDTO;
import com.sislocacao.api.model.dto.ReciboSaidaDTO;
import com.sislocacao.api.model.entity.Locacao;
import com.sislocacao.api.model.entity.Recibo;
import com.sislocacao.api.model.entity.Usuario;
import com.sislocacao.api.repositories.LocacaoRepository;
import com.sislocacao.api.repositories.ReciboRepository;
import com.sislocacao.api.services.LocacaoService;
import com.sislocacao.api.services.ReciboService;
import com.sislocacao.api.services.UsuarioService;

@Service
public class ReciboServiceImpl implements ReciboService {

	@Autowired
	private ReciboRepository reciboRepository;

	@Autowired
	private LocacaoRepository locacaoRepository;

	@Autowired
	private LocacaoService locacaoService;

	@Autowired
	private ReciboMapper reciboMapper;

	@Autowired

	private UsuarioService usuarioService;

	@Transactional
	@Override
	public ReciboSaidaDTO salvarRecibo(ReciboEntradaDTO reciboEntradaDTO) {
		// valida usuario autenticado
		Usuario user = usuarioService.validaUsuarioAutenticado();

		// recupera dados do contrato
		Locacao locacao = locacaoRepository.findById(reciboEntradaDTO.getLocacaoId())
				.orElseThrow(() -> new ResourceNotFoundException(
						"Locacação não encontrada com o id: " + reciboEntradaDTO.getLocacaoId()));

		// recupera ultimo recibo gerado para esse inquilino
		Recibo buscarUltimoReciboGerado = reciboRepository.buscarUltimoReciboGerado(reciboEntradaDTO.getLocacaoId());

		// incrementa o numero do recibo
		Integer numeroRecibo = buscarUltimoReciboGerado == null ? 1 : buscarUltimoReciboGerado.getNumeroRecibo() + 1;

		// calcula o total do recibo
		BigDecimal totalRecibo = calculaTotalRecibo(reciboEntradaDTO, locacao);

		// mapear recibo para uma entidade
		Recibo recibo = reciboMapper.paraReciboEntidade(reciboEntradaDTO, totalRecibo, numeroRecibo, locacao, user);

		// salvar recibo
		Recibo reciboSalvo = reciboRepository.save(recibo);

		return reciboMapper.paraReciboSaidaDto(reciboSalvo);
	}

	@Override
	public Page<ReciboSaidaDTO> listarRecibos(Long locacaoId, Integer page, Integer linesPerPage) {
		// Valida usuário autenticado
		Usuario user = usuarioService.validaUsuarioAutenticado();

		// Recupera dados de locação
		Locacao locacao = locacaoService.buscarLocacaoPorId(locacaoId);

		PageRequest pageRequest = PageRequest.of(page, linesPerPage);

		// Recupera recibos
		Page<Recibo> recibos = reciboRepository.findByUsuarioAndLocacao(user.getId(), locacao.getId(), pageRequest);

		// mapeia lista de recibos para um objeto de saída DTO
		List<ReciboSaidaDTO> listaRecibosSaida = recibos.getContent().stream()
				.map(recibo -> reciboMapper.paraReciboSaidaDto(recibo)).collect(Collectors.toList());

		return new PageImpl<>(listaRecibosSaida, pageRequest, recibos.getTotalElements());
	}

	@Override
	public Recibo buscarReciboPorId(Long id, Long locacaoId) {
		// Valida usuário autenticado
		usuarioService.validaUsuarioAutenticado();

		return reciboRepository.buscarReciboPorIdELocacao(id, locacaoId)
				.orElseThrow(() -> new ResourceNotFoundException("Recibo não encontrado com o id: " + id));
	}

	@Override
	public ReciboSaidaDTO atualizarRecibo(ReciboEntradaDTO reciboEntradaDto) {
		// valida usuario autenticado
		Usuario user = usuarioService.validaUsuarioAutenticado();

		// Recupera recibo
		reciboRepository.findById(reciboEntradaDto.getId()).orElseThrow(
				() -> new ResourceNotFoundException("Recibo não encontradao com o id: " + reciboEntradaDto.getId()));

		// recupera dados do contrato
		Locacao locacao = locacaoRepository.findById(reciboEntradaDto.getLocacaoId())
				.orElseThrow(() -> new ResourceNotFoundException(
						"Locacação não encontrada com o id: " + reciboEntradaDto.getLocacaoId()));

		// calcula o total do recibo
		BigDecimal totalRecibo = calculaTotalRecibo(reciboEntradaDto, locacao);

		// mapear recibo para uma entidade
		Recibo rec = reciboMapper.paraReciboEntidade(reciboEntradaDto, totalRecibo,
				reciboEntradaDto.getNumeroRecibo(), locacao, user);

		// salva e retorna recibo
		
		return reciboMapper.paraReciboSaidaDto(reciboRepository.save(rec));
	}

	private BigDecimal calculaTotalRecibo(ReciboEntradaDTO recibo, Locacao locacao) {
		return locacao.getImovel().getValor().add(recibo.getValorAgua()).add(recibo.getValorEnergia());
	}
}
