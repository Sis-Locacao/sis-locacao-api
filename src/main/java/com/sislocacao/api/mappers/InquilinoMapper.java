package com.sislocacao.api.mappers;

import org.springframework.stereotype.Component;

import com.sislocacao.api.model.dto.InquilinoDTO;
import com.sislocacao.api.model.entity.Inquilino;

@Component
public class InquilinoMapper {
	public InquilinoDTO inquilinoEntidadeParaInquilinoDto(Inquilino inquilino) {
		InquilinoDTO dto = new InquilinoDTO();
		dto.setId(inquilino.getId());
		dto.setNome(inquilino.getNome());
		dto.setRg(inquilino.getRg());
		dto.setCpf(inquilino.getCpf());
		
		return dto;
	}
}
