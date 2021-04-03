package com.mjv.grupo1.livraria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mjv.grupo1.livraria.model.Livro;
import com.mjv.grupo1.livraria.repository.LivroRepository;

@RequestMapping(path = "/livros")
@RestController
public class LivroController {
	
	@Autowired
	private LivroRepository repository;
	
	@PostMapping
	public void save (@RequestBody Livro livro) {
		repository.save(livro);
	}
	
	
	

}
