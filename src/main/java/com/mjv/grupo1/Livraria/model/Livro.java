package com.mjv.grupo1.Livraria.model;

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
	private String isbn, titulo;
	private Double valorDiaria;
	private Integer exemplares, reservados;
	
	
	public Livro() {
		
	}
	
	public Livro(Integer id, String isbn, String titulo, Double valorDiaria, Integer exemplares, Integer reservados) {
		this.id = id;
		this.isbn = isbn;
		this.titulo = titulo;
		this.valorDiaria = valorDiaria;
		this.exemplares = exemplares;
		this.reservados = reservados;
	}

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
}
