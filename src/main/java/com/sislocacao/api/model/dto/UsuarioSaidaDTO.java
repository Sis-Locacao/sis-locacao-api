package com.sislocacao.api.model.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UsuarioSaidaDTO {
	private Long id;
	private String nome;
	private String nacionalidade;
	private List<EnderecoDTO> enderecos = new ArrayList<>();
}
