package com.sislocacao.api.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ReciboSaidaDTO {
	private Long id;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private Integer numeroRecibo;
	private BigDecimal valorAgua;
	private BigDecimal valorEnergia;
	private BigDecimal totalJuros;
	private BigDecimal totalRecibo;
	private String totalPorExtenso;
}
