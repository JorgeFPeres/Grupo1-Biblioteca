package com.mjv.grupo1.livraria.model.sale;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.mjv.grupo1.livraria.model.library.DisponibilidadeStatus;
import com.mjv.grupo1.livraria.model.library.Livro;

@Entity
@Table(name = "loc_item")
public class LocacaoItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private LocalDate dataPrevisaoEntrega;
	private LocalDate dataEntrega;
	private Integer diarias;
	private Double valorDiaria;
	private Double valorLocacao;
	
	@Enumerated(EnumType.STRING)
	private DisponibilidadeStatus status;

	@ManyToOne
	@JoinColumn(name = "id_livro")
	private Livro livro;

	@ManyToOne
	@JoinColumn(name = "id_locacao")
	private Locacao locacao;

	public DisponibilidadeStatus getStatus() {
		return status;
	}
	public void setStatus(DisponibilidadeStatus status) {
		this.status = status;
	}
	public Locacao getLocacao() {
		return locacao;
	}

	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDataPrevisaoEntrega() {
		return dataPrevisaoEntrega;
	}

	public void setDataPrevisaoEntrega(LocalDate dataPrevisaoEntrega) {
		this.dataPrevisaoEntrega = dataPrevisaoEntrega;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Integer getDiarias() {
		return diarias;
	}

	public void setDiarias(Integer diarias) {
		this.diarias = diarias;
	}

	public Double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(Double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public Double getValorLocacao() {
		return valorLocacao;
	}

	public void setValorLocacao(Double valorLocacao) {
		this.valorLocacao = valorLocacao;
	}

}