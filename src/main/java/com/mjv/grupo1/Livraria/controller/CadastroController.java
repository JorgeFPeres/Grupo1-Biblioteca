package com.mjv.grupo1.Livraria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mjv.grupo1.Livraria.dto.CadastroDto;
import com.mjv.grupo1.Livraria.model.Cadastro;
import com.mjv.grupo1.Livraria.services.CadastroServices;

@RequestMapping(path = "/cadastros")
@RestController
public class CadastroController {
	
	private final CadastroServices cadastroServices;
	
	@Autowired
	public CadastroController(CadastroServices cadastroServices) {
		this.cadastroServices = cadastroServices;
	}
	
	
	@PostMapping
	public ResponseEntity<Cadastro> salvar(@RequestBody CadastroDto dto) {
		Cadastro cadastro = cadastroServices.salvar(dto.transformaParaObjeto());
		return new ResponseEntity<>(cadastro, HttpStatus.CREATED);
	}
}
