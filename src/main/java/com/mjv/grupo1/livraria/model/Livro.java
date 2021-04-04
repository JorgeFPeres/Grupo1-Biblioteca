package com.mjv.grupo1.livraria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "livro")
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String isbn;
	
	@Column(nullable = false)
	private String titulo;
	
	@Column(nullable = false)
	private Double valorDiaria;
	
	@Column(nullable = false)
	private Integer exemplares;
	
	@Column(nullable = false)
	private Integer reservados;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Double getValorDiaria() {
		return valorDiaria;
	}
	public void setValorDiaria(Double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}
	public Integer getExemplares() {
		return exemplares;
	}
	public void setExemplares(Integer exemplares) {
		this.exemplares = exemplares;
	}
	public Integer getReservados() {
		return reservados;
	}
	public void setReservados(Integer reservados) {
		this.reservados = reservados;
	}
//	public void incrementarReservado() {
//		exemplares--;
//		reservados++;
//	}
}
