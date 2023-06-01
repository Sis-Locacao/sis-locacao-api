package com.sislocacao.api.model.entity;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "tb_locacoes")
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
	@JoinColumn(name = "imovel_id")
	private Imovel imovel;
	
	@OneToOne
	@JoinColumn(name = "inquilino_id")
	private Inquilino inquilino;
	
	@OneToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@OneToMany(mappedBy = "locacao")
	private List<Recibo> recibos = new ArrayList<>();
}
