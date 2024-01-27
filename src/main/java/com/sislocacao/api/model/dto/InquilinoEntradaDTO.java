package com.sislocacao.api.model.dto;

import com.sislocacao.api.model.enums.EstadoCivilEnum;
import lombok.*;

@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class InquilinoEntradaDTO {
	private Long id;
	private String nome;
	private String rg;
	private String cpf;
	private String nacionalidade;
	private EstadoCivilEnum estadoCivil;
	private String profissao;
}
