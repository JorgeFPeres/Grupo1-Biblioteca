package com.mjv.grupo1.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mjv.grupo1.livraria.model.library.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer>{

	Livro findByTitulo(String titulo);
	
	void deleteByTitulo(String titulo);
}
