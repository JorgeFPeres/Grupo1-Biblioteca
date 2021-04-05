package com.mjv.grupo1.livraria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mjv.grupo1.livraria.model.library.Livro;
import com.mjv.grupo1.livraria.repository.LivroRepository;
import com.mjv.grupo1.livraria.services.LivroService;

import io.swagger.annotations.ApiOperation;

@RequestMapping(path = "/livros")
@RestController
public class LivroController {
	
	@Autowired
	private LivroRepository repository;
	
	@Autowired
	private LivroService service;
	
	@PostMapping("/cadastrarlivros")
	@ApiOperation(value = "Realiza o cadastro de um livro no database.")
	public void save (@RequestBody Livro livro) {
		repository.save(livro);
	}
	
	@GetMapping(value = "/listarlivros")
	@ApiOperation(value = "Retorna uma lista com todos os livros cadastrados.")
    public List<Livro> list(){
        return service.buscarAcervo();
    }
	
	@GetMapping("/buscarlivros")
	@ApiOperation(value = "Realiza uma pesquisa através do titulo informado.")
    public Livro pesquisarLivro(String titulo){
        return service.buscarLivro(titulo);
    }
	
	@DeleteMapping("/deletarlivros")
	@ApiOperation(value = "Deleta um livro identificado pelo titulo")
	public void deletarLivro(String titulo) {
		repository.deleteByTitulo(titulo);
	}
	
}
