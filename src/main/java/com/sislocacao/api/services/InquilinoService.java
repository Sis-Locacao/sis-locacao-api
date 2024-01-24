package com.sislocacao.api.services;

import com.sislocacao.api.model.dto.InquilinoDTO;
import com.sislocacao.api.model.dto.InquilinoEntradaDTO;

public interface InquilinoService {
	
	/**
	 * Metodo responsável por salvar um inquilino
	 * @param inquilinoDto
	 * @return InquilinoDTO
	 */
	InquilinoDTO salvarInquilino(final InquilinoEntradaDTO inquilinoDto);
}
