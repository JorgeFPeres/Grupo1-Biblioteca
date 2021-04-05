package com.mjv.grupo1.livraria.model.sale;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.mjv.grupo1.livraria.model.client.Cadastro;

@Entity
@Table(name = "locacao")
public class Locacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private LocalDate dataAgendamento;
	private LocalDate dataRetirada;
	
	@Column(nullable = false)
	private LocalDate dataFinalizacao;
	
	@OneToMany(mappedBy = "locacao", cascade = CascadeType.PERSIST)
	private List<LocacaoItem> itens = new ArrayList<LocacaoItem>();
	
	@ManyToOne
	@JoinColumn(name = "id_cadastro")
	private Cadastro cadastro;
	private Double valorTotal;
	
	@Transient
	private Integer diariasConcluidas;
	
	@Enumerated(EnumType.STRING)
	private LocacaoStatus status;

	public void addItem(LocacaoItem item) {
		item.setLocacao(this);
		this.valorTotal = this.valorTotal + item.getValorLocacao();
		itens.add(item);
	}
	
	public Integer getDiariasConcluidas() {
		return diariasConcluidas;
	}

	public void setDiariasConcluidas(Integer diariasConcluidas) {
		this.diariasConcluidas = diariasConcluidas;
	}

	public LocalDate getDataEntrega() {
		return dataFinalizacao;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataFinalizacao = dataEntrega;
	}

	public LocacaoStatus getStatus() {
		return status;
	}

	public void setStatus(LocacaoStatus status) {
		this.status = status;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

	public Cadastro getCadastro() {
		return cadastro;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(LocalDate dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public LocalDate getDataRetirada() {
		return dataRetirada;
	}

	public void setDataRetirada(LocalDate dataRetirada) {
		this.dataRetirada = dataRetirada;
	}

	public LocalDate getDataFinalizacao() {
		return dataFinalizacao;
	}

	public void setDataFinalizacao(LocalDate dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}

	public List<LocacaoItem> getItens() {
		return itens;
	}

	public void setItens(List<LocacaoItem> itens) {
		this.itens = itens;
	}

}