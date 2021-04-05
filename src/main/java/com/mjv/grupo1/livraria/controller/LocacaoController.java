package com.mjv.grupo1.livraria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mjv.grupo1.livraria.dto.LocacaoDto;
import com.mjv.grupo1.livraria.model.sale.Locacao;
import com.mjv.grupo1.livraria.services.LocacaoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/locacoes")
public class LocacaoController {
	
	@Autowired
	private LocacaoService service;
	
	@PostMapping("/realizarlocacao")
	@ApiOperation(value = "Gera uma locação e persiste seus dados.")
	public void post(@RequestBody LocacaoDto body) {
		service.gerarLocacao(body);
	}
	
	@GetMapping("/consultarlocacao")
	@ApiOperation(value = "Realiza a consulta de uma locação ja existente.")
	public Locacao consultarLocacao(String cpf) {
		return service.consultarLocacao(cpf);
	}
	
	@GetMapping("/realizardevolucao")
	@ApiOperation(value = "Finaliza uma locação existente.")
	public void realizarDevolucao(String cpf) {
		service.gerarDevolucao(cpf);
	}

}
