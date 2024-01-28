package com.sislocacao.api.model.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ImovelEntradaDTO {
	private Long id;
	private String apelido;
	private String descricao;
	private BigDecimal valor;
	private Boolean garagem;
	
	private EnderecoDTO endereco;
}
