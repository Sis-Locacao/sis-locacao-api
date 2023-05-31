package com.sislocacao.api.services;

import com.sislocacao.api.model.entity.Locacao;

public interface LocacaoService {
	
	/**
	 * Retorna os dados de uma locação com base no id fornecido por parâmetro
	 * 
	 * @param id da locação
	 * @return Um objeto Locacao com os dados da locação.
	 */
	public Locacao buscarLocacaoPorId(final Long id);
}
