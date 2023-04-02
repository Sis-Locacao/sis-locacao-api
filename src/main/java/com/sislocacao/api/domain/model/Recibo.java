package com.sislocacao.api.domain.model;


import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Recibo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private Integer numeroRecibo;
	private BigDecimal valorAgua;
	private BigDecimal valorEnergia;
	private BigDecimal totalJuros;
	private BigDecimal totalRecibo;
	private String totalPorExtenso;
	
	@ManyToOne
	private Locacao locacao;
}
