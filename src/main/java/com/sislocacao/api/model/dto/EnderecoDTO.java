package com.sislocacao.api.model.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class EnderecoDTO {
	private Long id;

	private String cep;
	private String rua;
	private String numero;
	private String cidade;
	private String estado;
}
