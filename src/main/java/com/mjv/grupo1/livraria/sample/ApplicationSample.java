package com.mjv.grupo1.livraria.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mjv.grupo1.livraria.model.client.Cadastro;
import com.mjv.grupo1.livraria.model.library.Livro;
import com.mjv.grupo1.livraria.repository.CadastroRepository;

@Component
public class ApplicationSample {
	@Autowired
	private CadastroRepository cadastroRepository;
	
	public void criarCadastro() {
		Cadastro cad = new Cadastro();
		cad.setNome("Jorge Peres");
		cad.setEmail("jorge-peres@live.com");
		
		cadastroRepository.save(cad);
	}
	public Cadastro buscarCadastro(Integer id) {
		Cadastro cad = cadastroRepository.findById(id).get();
		if(cad==null) {
			criarCadastro();
			cad = cadastroRepository.findById(id).get();
		}
		return cad;
	}
	public void fazerLocacaoLivro() {
		Livro livro = new Livro();
		livro.setTitulo("O Pescador");
		
	}
	
	
}
