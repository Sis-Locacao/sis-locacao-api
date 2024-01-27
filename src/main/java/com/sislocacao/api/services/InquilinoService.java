package com.sislocacao.api.services;

import java.util.List;

import com.sislocacao.api.model.dto.InquilinoDTO;
import com.sislocacao.api.model.dto.InquilinoEntradaDTO;

public interface InquilinoService {
	
	/**
	 * Metodo responsável por salvar um inquilino
	 * @param inquilinoDto
	 * @return InquilinoDTO
	 */
	InquilinoDTO salvar(final InquilinoEntradaDTO inquilinoDto);
	
	/**
	 * Metodo responsável por listar todos os inquilinos de um usuário específico
	 * @return Lista de InquilinoDTO
	 */
	List<InquilinoDTO> listar();
}
