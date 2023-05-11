package com.sislocacao.api.model.dto;

import java.util.ArrayList;
import java.util.List;

import com.sislocacao.api.model.enums.EstadoCivilEnum;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UsuarioEntradaDTO {
	private Long id;
	private String nome;
	private String rg;
	private String cpf;
	private String nacionalidade;
	private String email;
	private String senha;
	
	private EstadoCivilEnum estadoCivil;
	
	private List<EnderecoDTO> enderecos = new ArrayList<>();
}
