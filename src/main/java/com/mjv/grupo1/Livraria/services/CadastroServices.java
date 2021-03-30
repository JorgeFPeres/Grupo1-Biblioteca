package com.mjv.grupo1.Livraria.services;


import org.springframework.beans.factory.annotation.Autowired;

import com.mjv.grupo1.Livraria.model.Cadastro;
import com.mjv.grupo1.Livraria.repository.CadastroRepository;

public class CadastroServices {
	
	@Autowired
	private CadastroRepository cadastroRepository;
	
	
	public void insert(Cadastro cadastro) {
		if(cadastro==null)
			System.out.println("O Cadastro não pode ser nulo");
		
		String login = cadastro.getLogin();
		
		if(login ==null || login.length() >20)
			System.out.println("O login não pode ser nulo e nem ter 20 caracteres");
		
		cadastroRepository.save(cadastro);
	}
	
	
}
