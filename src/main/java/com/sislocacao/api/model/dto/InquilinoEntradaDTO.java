package com.sislocacao.api.model.dto;

import com.sislocacao.api.model.enums.EstadoCivilEnum;

public class InquilinoEntradaDTO {
	private Long id;
	private String nome;
	private String rg;
	private String cpf;
	private String nacionalidade;
	private EstadoCivilEnum estadoCivil;
	private String profissao;
	
	public InquilinoEntradaDTO() {
	}

	public InquilinoEntradaDTO(Long id, String nome, String rg, String cpf, String nacionalidade,
			EstadoCivilEnum estadoCivil, String profissao) {
		super();
		this.id = id;
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.nacionalidade = nacionalidade;
		this.estadoCivil = estadoCivil;
		this.profissao = profissao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public EstadoCivilEnum getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivilEnum estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	@Override
	public String toString() {
		return "InquilinoEntradaDTO [id=" + id + ", nome=" + nome + ", rg=" + rg + ", cpf=" + cpf + ", nacionalidade="
				+ nacionalidade + ", estadoCivil=" + estadoCivil + ", profissao=" + profissao + "]";
	}
}
