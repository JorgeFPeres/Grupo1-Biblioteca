package com.mjv.grupo1.Livraria.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "locacao")
public class Locacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Date dataAgendamento;
	private Date dataRetirada;
	private Date finalizacao;
	private Double valorTotal;
	
	private LocacaoStatus status;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cadastro_id", referencedColumnName= "id")
	Cadastro cadastro;
	
	
	//Construtores
	public Locacao() {
	}
	
	public Locacao(Integer id, Date dataAgendamento, Date dataRetirada, Date finalizacao, Double valorTotal,
			LocacaoStatus status, Cadastro cadastro) {
		this.id = id;
		this.dataAgendamento = dataAgendamento;
		this.dataRetirada = dataRetirada;
		this.finalizacao = finalizacao;
		this.valorTotal = valorTotal;
		this.status = status;
		this.cadastro = cadastro;
	}
	
	
	//Getters and Setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDataAgendamento() {
		return dataAgendamento;
	}
	public void setDataAgendamento(Date dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}
	public Date getDataRetirada() {
		return dataRetirada;
	}
	public void setDataRetirada(Date dataRetirada) {
		this.dataRetirada = dataRetirada;
	}
	public Date getFinalizacao() {
		return finalizacao;
	}
	public void setFinalizacao(Date finalizacao) {
		this.finalizacao = finalizacao;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public LocacaoStatus getStatus() {
		return status;
	}
	public void setStatus(LocacaoStatus status) {
		this.status = status;
	}
}
