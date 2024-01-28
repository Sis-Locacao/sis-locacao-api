package com.sislocacao.api.services;

import java.util.List;

import com.sislocacao.api.model.dto.ImovelDTO;
import com.sislocacao.api.model.dto.ImovelEntradaDTO;

public interface ImovelService {
	
	/**
	 * Metodo responsável por salvar um imovel
	 * @param ImovelDTO
	 * @return ImovelDTO
	 */
	ImovelDTO salvar(final ImovelEntradaDTO imovelDTO);
	
	/**
	 * @return Lista de ImovelDTO
	 */
	List<ImovelDTO> listar();
	
	/**
	 * Metodo responsável por buscar um imovel pelo ID
	 * @param id
	 * @return ImovelDTO
	 */
	ImovelDTO buscarPorId(final Long id);
	
	/**
	 * Metodo responsável por excluir um imovel
	 * @param id
	 */
	void delete(final Long id);
	
	/**
	 * Metodo responsável por atualizar os dados de um imovel
	 * @param id
	 * @param ImovelDTO
	 * @return ImovelDTO atualizado
	 */
	ImovelDTO atualizar(final Long id, final ImovelEntradaDTO imovelDTO);
}
