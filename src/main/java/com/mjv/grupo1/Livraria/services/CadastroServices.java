package com.mjv.grupo1.Livraria.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.mjv.grupo1.Livraria.model.Cadastro;
import com.mjv.grupo1.Livraria.repository.CadastroRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CadastroServices {
	
	private final CadastroRepository cadastroRepository;
	
	@Autowired
	public CadastroServices(CadastroRepository cadastroRepository) {
		this.cadastroRepository = cadastroRepository;
	}
	
	public Cadastro salvar(Cadastro cadastro) {
		return cadastroRepository.save(cadastro);
	}
	
}
