package com.sislocacao.api.services.impl;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sislocacao.api.exceptions.impl.ResourceNotFoundException;
import com.sislocacao.api.exceptions.impl.SisLocacaoException;
import com.sislocacao.api.model.dto.ReciboEntradaDTO;
import com.sislocacao.api.model.entity.Locacao;
import com.sislocacao.api.model.entity.Recibo;
import com.sislocacao.api.repositories.LocacaoRepository;
import com.sislocacao.api.repositories.ReciboRepository;
import com.sislocacao.api.services.ReciboService;
import com.sislocacao.api.utils.ValorPorExtenso;

@Service
public class ReciboServiceImpl implements ReciboService {

	@Autowired
	private ReciboRepository reciboRepository;

	@Autowired
	private LocacaoRepository locacaoRepository;

	@Transactional
	@Override
	public void salvarRecibo(ReciboEntradaDTO reciboEntradaDTO) {
		// recupera dados do contrato
		Locacao locacao = locacaoRepository.findById(reciboEntradaDTO.getLocacaoId())
				.orElseThrow(() -> new ResourceNotFoundException(
						"Locacação não encontrada com o id: " + reciboEntradaDTO.getLocacaoId()));

		// valida se o contrato esta vencido
		if (locacao.getDataFim().isBefore(LocalDate.now())) {
			throw new SisLocacaoException("Esse contrato de locação encontra-se vencido");
		}

		// recupera ultimo recibo gerado para esse inquilino
		Recibo buscarUltimoReciboGerado = reciboRepository.buscarUltimoReciboGerado(reciboEntradaDTO.getLocacaoId());

		// incrementa o numero do recibo
		Integer numeroRecibo = buscarUltimoReciboGerado.getNumeroRecibo() + 1;

		// calculo o total do recibo
		BigDecimal totalRecibo = calculaTotalRecibo(reciboEntradaDTO);

		// escreve valor total por extenso
		String string = new ValorPorExtenso(totalRecibo).toString();

		// mapear recibo para uma entidade
		
		// salvar recibo
		return;
	}

	@Override
	public Recibo buscarReciboPorId(long Id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private BigDecimal calculaTotalRecibo(ReciboEntradaDTO recibo) {
		// realiza calculo de juros
		
		return BigDecimal.ONE;
	}

}
