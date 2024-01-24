package com.sislocacao.api.mappers;

import org.springframework.stereotype.Component;

import com.sislocacao.api.model.dto.InquilinoDTO;
import com.sislocacao.api.model.dto.InquilinoEntradaDTO;
import com.sislocacao.api.model.entity.Inquilino;
import com.sislocacao.api.model.entity.Usuario;

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
	
	public Inquilino inquilinoDtoParaInquilinoEntidade(final InquilinoEntradaDTO inquilinoDto, final Usuario usuario) {
		Inquilino inquilino = new Inquilino();
		inquilino.setNome(inquilinoDto.getNome());
		inquilino.setRg(inquilinoDto.getRg());
		inquilino.setCpf(inquilinoDto.getCpf());
		inquilino.setProfissao(inquilinoDto.getProfissao());
		inquilino.setNacionalidade(inquilinoDto.getNacionalidade());
		inquilino.setEstadoCivil(inquilinoDto.getEstadoCivil());
		inquilino.setUsuario(usuario);
		return inquilino;
	}
}
