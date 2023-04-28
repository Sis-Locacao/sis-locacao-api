package com.sislocacao.api.model.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.sislocacao.api.model.enums.EstadoCivilEnum;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Inquilino {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	private String nome;
	private String rg;
	private String cpf;
	private String nacionalidade;
	private EstadoCivilEnum estadoCivil;
	private String profissao;
	
	@ManyToOne
	private Usuario usuario;
}
