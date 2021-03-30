package com.mjv.grupo1.Livraria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mjv.grupo1.Livraria.model.Cadastro;
import com.mjv.grupo1.Livraria.services.CadastroServices;

@RestController
@RequestMapping(path = "/cadastros")

public class CadastroController {
	@Autowired
	private CadastroServices cadastroServices;
	
	
	@PostMapping
	public void post(@RequestBody Cadastro cadastro) {
		cadastroServices.insert(cadastro);
	}
}
