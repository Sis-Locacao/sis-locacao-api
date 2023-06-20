package com.sislocacao.api.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sislocacao.api.model.dto.LocacaoDTO;
import com.sislocacao.api.model.dto.ReciboSaidaDTO;
import com.sislocacao.api.model.entity.Locacao;

@Component
public class LocacaoMapper {
	
	@Autowired
	private InquilinoMapper inquilinoMapper;
	
	@Autowired
	private ReciboMapper reciboMapper;
	
	public LocacaoDTO locacaoEntidadaParaLocacaoSaidaDto (final Locacao locacao) {
		LocacaoDTO dto = new LocacaoDTO();
		
		dto.setDataInicio(locacao.getDataInicio());
		dto.setDataFim(locacao.getDataFim());
		dto.setId(locacao.getId());
		dto.setValorCaucao(locacao.getValorCaucao());
		
		dto.setInquilino(inquilinoMapper.inquilinoEntidadeParaInquilinoDto(locacao.getInquilino()));
		
		List<ReciboSaidaDTO> reciboSaidaDto = new ArrayList<>();
		
		locacao.getRecibos().forEach(recibo ->{
			reciboSaidaDto.add(reciboMapper.paraReciboSaidaDto(recibo));
		});
		
		dto.setRecibos(reciboSaidaDto);
		
		return dto;
	}
}
