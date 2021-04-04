package com.mjv.grupo1.livraria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjv.grupo1.livraria.exception.config.RegistroNaoLocalizadoException;
import com.mjv.grupo1.livraria.model.library.Livro;
import com.mjv.grupo1.livraria.repository.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository repository;
	
	public List<Livro> buscarAcervo(){
		return repository.findAll();
	}
	
	public Livro buscarLivro(String titulo) {
		if (repository.findByTitulo(titulo) == null)
			throw new RegistroNaoLocalizadoException(titulo);
		
		return repository.findByTitulo(titulo);
	}
	
	public boolean verificarDisponibilidade(String titulo) {
		return buscarLivro(titulo).getExemplares() > 0 ? true : false;
	}
}
