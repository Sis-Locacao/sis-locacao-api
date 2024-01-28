package com.sislocacao.api.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_imoveis")
public class Imovel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	@Cascade(CascadeType.ALL)
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;

	public Imovel() {
	}

	public Imovel(Long id, String apelido, String descricao, BigDecimal valor, Boolean garagem, Usuario usuario,
			Endereco endereco) {
		super();
		this.id = id;
		this.apelido = apelido;
		this.descricao = descricao;
		this.valor = valor;
		this.garagem = garagem;
		this.usuario = usuario;
		this.endereco = endereco;
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

	public Boolean getGaragem() {
		return garagem;
	}

	public void setGaragem(Boolean garagem) {
		this.garagem = garagem;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Locacao> getLocacoes() {
		return locacoes;
	}

	public void setLocacoes(List<Locacao> locacoes) {
		this.locacoes = locacoes;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Imovel [id=" + id + ", apelido=" + apelido + ", descricao=" + descricao + ", valor=" + valor
				+ ", garagem=" + garagem + ", usuario=" + usuario + ", locacoes=" + locacoes + ", endereco=" + endereco
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Imovel other = (Imovel) obj;
		return Objects.equals(id, other.id);
	}
}
