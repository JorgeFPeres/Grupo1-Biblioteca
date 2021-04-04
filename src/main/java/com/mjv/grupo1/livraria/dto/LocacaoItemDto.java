package com.mjv.grupo1.livraria.dto;

import java.time.LocalDate;

public class LocacaoItemDto {
	private Integer idLivro;
	private String titulo;
	private LocalDate dataPrevisaoEntrega;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Integer getIdLivro() {
		return idLivro;
	}
	public void setIdLivro(Integer idLivro) {
		this.idLivro = idLivro;
	}
	public LocalDate getDataPrevisaoEntrega() {
		return dataPrevisaoEntrega;
	}
	public void setDataPrevisaoEntrega(LocalDate dataPrevisaoEntrega) {
		this.dataPrevisaoEntrega = dataPrevisaoEntrega;
	}
	
}