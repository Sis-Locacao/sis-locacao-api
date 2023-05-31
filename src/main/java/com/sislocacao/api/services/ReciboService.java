package com.sislocacao.api.services;

import com.sislocacao.api.model.dto.ReciboEntradaDTO;
import com.sislocacao.api.model.entity.Recibo;

public interface ReciboService {
	
	/**
	 * Salva um novo recibo com base nos dados fornecidos no objeto ReciboEntradaDTO.
	 * 
	 * @param reciboEntradaDTO O objeto ReciboEntradaDTO contendo parte dos dados de recibo a ser salvo
	 */
	public void salvarRecibo(ReciboEntradaDTO reciboEntradaDTO);
	
	/**
	 * Busca os dados de um recibo
	 * 
	 * @param id do recibo
	 */
	public Recibo buscarReciboPorId(final long Id);
}
