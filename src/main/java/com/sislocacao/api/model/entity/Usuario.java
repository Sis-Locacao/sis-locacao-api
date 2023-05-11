package com.sislocacao.api.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.sislocacao.api.model.enums.EstadoCivilEnum;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "tb_usuarios")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

	private String nome;
	private String rg;
	private String cpf;
	private String nacionalidade;
	private String email;
	private String senha;

	private EstadoCivilEnum estadoCivil;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "usuario_endereco", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "endereco_id"))
	private List<Endereco> enderecos = new ArrayList<>();
}
