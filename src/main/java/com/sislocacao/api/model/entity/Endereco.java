package com.sislocacao.api.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "tb_enderecos")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

	private String cep;
	private String rua;
	private String numero;
	private String cidade;
	private String estado;
	
	@ManyToMany(mappedBy = "enderecos")
	private List<Usuario> usuarios = new ArrayList<>();
}
