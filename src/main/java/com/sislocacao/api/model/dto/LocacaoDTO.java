package com.sislocacao.api.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class LocacaoDTO {
	private Long id;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private BigDecimal valorCaucao;
	
	private InquilinoDTO inquilino;
}
