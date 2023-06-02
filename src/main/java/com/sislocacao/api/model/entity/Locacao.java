package com.sislocacao.api.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_locacoes")
public class Locacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDate dataInicio;
	private LocalDate dataFim;
	private BigDecimal valorCaucao;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "imovel_id")
	private Imovel imovel;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "inquilino_id")
	private Inquilino inquilino;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	@OneToMany(mappedBy = "locacao", fetch = FetchType.EAGER)
	private List<Recibo> recibos = new ArrayList<>();

	public Locacao() {
	}

	public Locacao(Long id, LocalDate dataInicio, LocalDate dataFim, BigDecimal valorCaucao, Imovel imovel,
			Inquilino inquilino, Usuario usuario) {
		super();
		this.id = id;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.valorCaucao = valorCaucao;
		this.imovel = imovel;
		this.inquilino = inquilino;
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public BigDecimal getValorCaucao() {
		return valorCaucao;
	}

	public void setValorCaucao(BigDecimal valorCaucao) {
		this.valorCaucao = valorCaucao;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public Inquilino getInquilino() {
		return inquilino;
	}

	public void setInquilino(Inquilino inquilino) {
		this.inquilino = inquilino;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Recibo> getRecibos() {
		return recibos;
	}

	public void setRecibos(List<Recibo> recibos) {
		this.recibos = recibos;
	}

	@Override
	public String toString() {
		return "Locacao [id=" + id + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + ", valorCaucao="
				+ valorCaucao + ", imovel=" + imovel + ", inquilino=" + inquilino + ", usuario=" + usuario
				+ ", recibos=" + recibos + "]";
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
		Locacao other = (Locacao) obj;
		return Objects.equals(id, other.id);
	}

}
