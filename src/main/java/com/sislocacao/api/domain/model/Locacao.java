package com.sislocacao.api.domain.model;


import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Locacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private BigDecimal valorCaucao;
	
	@OneToOne
	private Imovel imovel;
	
	@ManyToOne
	private Inquilino inquilino;
	
	@ManyToOne
	private Usuario usuario;
}
