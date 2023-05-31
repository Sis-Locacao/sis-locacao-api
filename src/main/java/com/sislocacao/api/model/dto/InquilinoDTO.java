package com.sislocacao.api.model.dto;

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
public class InquilinoDTO {
	private Long id;
	private String nome;
	private String rg;
	private String cpf;
}
