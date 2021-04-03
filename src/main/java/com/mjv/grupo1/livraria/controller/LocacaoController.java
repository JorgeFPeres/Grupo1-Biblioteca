package com.mjv.grupo1.livraria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mjv.grupo1.livraria.dto.LocacaoDto;
import com.mjv.grupo1.livraria.services.LocacaoService;

@RestController
@RequestMapping(path = "/locacoes")
public class LocacaoController {
	
	@Autowired
	private LocacaoService service;
	
	@PostMapping
	public void post(@RequestBody LocacaoDto body) {
		service.gerarLocacao(body);
	}

}
