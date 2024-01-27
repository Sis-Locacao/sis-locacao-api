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
	
	/**
	 * Metodo responsável por buscar um inquilino pelo ID
	 * @param id
	 * @return InquilinoDTO
	 */
	InquilinoDTO buscarPorId(final Long id);
	
	/**
	 * Metodo responsável por excluir um inquilino
	 * @param id
	 */
	void delete(final Long id);
	
	/**
	 * Metodo responsável por atualizar os dados de um inquilino
	 * @param id
	 * @param inquilinoDto
	 * @return InquilinoDto atualizado
	 */
	InquilinoDTO atualizar(final Long id, final InquilinoEntradaDTO inquilinoDto);
}
