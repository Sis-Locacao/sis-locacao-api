package com.sislocacao.api.services;

import org.springframework.data.domain.Page;

import com.sislocacao.api.model.dto.ReciboEntradaDTO;
import com.sislocacao.api.model.dto.ReciboSaidaDTO;
import com.sislocacao.api.model.entity.Recibo;

public interface ReciboService {
	
	/**
	 * Salva um novo recibo com base nos dados fornecidos no objeto ReciboEntradaDTO.
	 * 
	 * @param reciboEntradaDTO O objeto ReciboEntradaDTO contendo parte dos dados de recibo a ser salvo
	 */
	public ReciboSaidaDTO salvarRecibo(ReciboEntradaDTO reciboEntradaDTO);
	
	/**
	 * Recupera um recibo de aluguel pelo id do recibo e id da locação
	 * 
	 * @param id
	 * @param locacaoId
	 * 
	 * @return Objeto contendo os dados de Recibo
	 */
	public Recibo buscarReciboPorId(Long id, Long locacaoId);	
	
	/**
	 * Retorna uma lista paginada de recibos pela locação associada a esse recibo
	 * 
	 * @param locacaoId
	 * @param page
	 * @param linesPerPage
	 * 
	 * @return Lista páginada de ReciboSaidaDTO
	 */
	public Page<ReciboSaidaDTO> listarRecibos(final Long locacaoId, Integer page, Integer linesPerPage);
}
