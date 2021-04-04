package com.mjv.grupo1.livraria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mjv.grupo1.livraria.model.Livro;
import com.mjv.grupo1.livraria.repository.LivroRepository;
import com.mjv.grupo1.livraria.services.LivroService;

@RequestMapping(path = "/livros")
@RestController
public class LivroController {
	
	@Autowired
	private LivroRepository repository;
	
	@Autowired
	private LivroService service;
	
	@PostMapping
	public void save (@RequestBody Livro livro) {
		repository.save(livro);
	}
	
	@GetMapping(value = "/livros")
    public List<Livro> list(){
        return service.buscarAcervo();
    }
	
	@GetMapping
    public Livro pesquisarLivro(String titulo){
        return service.buscarLivro(titulo);
    }
	
}
