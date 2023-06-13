package com.sislocacao.api.services.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sislocacao.api.exceptions.impl.ResourceNotFoundException;
import com.sislocacao.api.mappers.ReciboMapper;
import com.sislocacao.api.model.dto.ReciboEntradaDTO;
import com.sislocacao.api.model.entity.Locacao;
import com.sislocacao.api.model.entity.Recibo;
import com.sislocacao.api.repositories.LocacaoRepository;
import com.sislocacao.api.repositories.ReciboRepository;
import com.sislocacao.api.services.ReciboService;

@Service
public class ReciboServiceImpl implements ReciboService {

	@Autowired
	private ReciboRepository reciboRepository;

	@Autowired
	private LocacaoRepository locacaoRepository;

	@Autowired
	private ReciboMapper reciboMapper;
	
	@Transactional
	@Override
	public void salvarRecibo(ReciboEntradaDTO reciboEntradaDTO) {
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
		Recibo recibo = reciboMapper.paraReciboEntidade(reciboEntradaDTO, totalRecibo, numeroRecibo, locacao);
		
		// salvar recibo
		reciboRepository.save(recibo);
	}

	@Override
	public Recibo buscarReciboPorId(long Id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private BigDecimal calculaTotalRecibo(ReciboEntradaDTO recibo, Locacao locacao) {
		return locacao.getImovel().getValor().add(recibo.getValorAgua()).add(recibo.getValorEnergia());
	}

}
