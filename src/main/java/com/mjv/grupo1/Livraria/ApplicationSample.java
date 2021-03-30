package com.mjv.grupo1.Livraria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mjv.grupo1.Livraria.model.Cadastro;
import com.mjv.grupo1.Livraria.repository.CadastroRepository;

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
}
