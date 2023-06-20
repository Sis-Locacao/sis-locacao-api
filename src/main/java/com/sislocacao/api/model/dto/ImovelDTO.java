package com.sislocacao.api.model.dto;

import java.math.BigDecimal;

public class ImovelDTO {
	private Long id;
	private String apelido;
	private String descricao;
	private BigDecimal valor;

	public ImovelDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "ImovelDTO [id=" + id + ", apelido=" + apelido + ", descricao=" + descricao + ", valor=" + valor + "]";
	}
}
