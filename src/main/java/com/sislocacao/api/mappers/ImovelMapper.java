package com.sislocacao.api.mappers;

import org.springframework.stereotype.Component;

import com.sislocacao.api.model.dto.ImovelDTO;
import com.sislocacao.api.model.entity.Imovel;

@Component
public class ImovelMapper {
	
	public ImovelDTO imovelEntidadeParaImovelDto(Imovel imovel) {
		ImovelDTO dto = new ImovelDTO();
		dto.setApelido(imovel.getApelido());
		dto.setDescricao(imovel.getDescricao());
		dto.setId(imovel.getId());
		dto.setValor(imovel.getValor());
		
		return dto;
	}
}
