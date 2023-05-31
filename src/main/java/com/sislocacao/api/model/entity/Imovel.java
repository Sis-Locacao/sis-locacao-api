package com.sislocacao.api.model.entity;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "tb_imoveis")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Imovel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	private String apelido;
	private String descricao;
	private BigDecimal valor;
	private Boolean garagem;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@JsonIgnore
	@OneToMany(mappedBy = "imovel")
	private List<Locacao> locacoes = new ArrayList<>();
	
	@OneToOne
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;
}
