package com.sislocacao.api.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ReciboEntradaDTO {
	private Long id;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private BigDecimal valorAgua;
	private BigDecimal valorEnergia;
	private Long locacaoId;
	private Integer numeroRecibo;
}
