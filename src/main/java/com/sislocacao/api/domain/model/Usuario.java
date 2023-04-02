package com.sislocacao.api.domain.model;


import com.sislocacao.api.domain.enumerators.EstadoCivilEnum;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	private String nome;
	private String rg;
	private String cpf;
	private String nacionalidade;
	private String email;
	private String senha;
	
	private EstadoCivilEnum estadoCivil;
}
