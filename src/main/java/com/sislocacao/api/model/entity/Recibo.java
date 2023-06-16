package com.sislocacao.api.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_recibos")
public class Recibo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDate dataInicio;
	private LocalDate dataFim;
	private Integer numeroRecibo;
	private BigDecimal valorAgua;
	private BigDecimal valorEnergia;
	private BigDecimal totalJuros;
	private BigDecimal totalRecibo;
	private String totalPorExtenso;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "locacao_id")
	private Locacao locacao;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	public Recibo() {
	}

	public Recibo(Long id, LocalDate dataInicio, LocalDate dataFim, Integer numeroRecibo, BigDecimal valorAgua,
			BigDecimal valorEnergia, BigDecimal totalJuros, BigDecimal totalRecibo, String totalPorExtenso,
			Locacao locacao, Usuario usuario) {
		super();
		this.id = id;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.numeroRecibo = numeroRecibo;
		this.valorAgua = valorAgua;
		this.valorEnergia = valorEnergia;
		this.totalJuros = totalJuros;
		this.totalRecibo = totalRecibo;
		this.totalPorExtenso = totalPorExtenso;
		this.locacao = locacao;
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

	public Integer getNumeroRecibo() {
		return numeroRecibo;
	}

	public void setNumeroRecibo(Integer numeroRecibo) {
		this.numeroRecibo = numeroRecibo;
	}

	public BigDecimal getValorAgua() {
		return valorAgua;
	}

	public void setValorAgua(BigDecimal valorAgua) {
		this.valorAgua = valorAgua;
	}

	public BigDecimal getValorEnergia() {
		return valorEnergia;
	}

	public void setValorEnergia(BigDecimal valorEnergia) {
		this.valorEnergia = valorEnergia;
	}

	public BigDecimal getTotalJuros() {
		return totalJuros;
	}

	public void setTotalJuros(BigDecimal totalJuros) {
		this.totalJuros = totalJuros;
	}

	public BigDecimal getTotalRecibo() {
		return totalRecibo;
	}

	public void setTotalRecibo(BigDecimal totalRecibo) {
		this.totalRecibo = totalRecibo;
	}

	public String getTotalPorExtenso() {
		return totalPorExtenso;
	}

	public void setTotalPorExtenso(String totalPorExtenso) {
		this.totalPorExtenso = totalPorExtenso;
	}

	public Locacao getLocacao() {
		return locacao;
	}

	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Recibo [id=" + id + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + ", numeroRecibo="
				+ numeroRecibo + ", valorAgua=" + valorAgua + ", valorEnergia=" + valorEnergia + ", totalJuros="
				+ totalJuros + ", totalRecibo=" + totalRecibo + ", totalPorExtenso=" + totalPorExtenso + ", locacao="
				+ locacao + ", usuario=" + usuario + "]";
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
		Recibo other = (Recibo) obj;
		return Objects.equals(id, other.id);
	}

}
