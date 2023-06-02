package com.sislocacao.api.mappers;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.sislocacao.api.model.dto.ReciboEntradaDTO;
import com.sislocacao.api.model.entity.Locacao;
import com.sislocacao.api.model.entity.Recibo;
import com.sislocacao.api.utils.ValorPorExtenso;

@Component
public class ReciboMapper {
	
	public Recibo paraReciboEntidade(final ReciboEntradaDTO reciboDto, final BigDecimal totalRecibo, final Integer numeroRecibo, final Locacao locacao) {
		Recibo recibo = new Recibo();
		
		recibo.setNumeroRecibo(numeroRecibo);
		recibo.setTotalJuros(BigDecimal.ZERO);
		
		// escreve valor total por extenso
		recibo.setTotalPorExtenso(new ValorPorExtenso(totalRecibo).toString());
		
		recibo.setTotalRecibo(totalRecibo);
		recibo.setValorAgua(reciboDto.getValorAgua());
		recibo.setValorEnergia(reciboDto.getValorEnergia());
		recibo.setDataInicio(reciboDto.getDataInicio());
		recibo.setDataFim(reciboDto.getDataFim());
		recibo.setLocacao(locacao);
		
		return recibo;
	}
}
