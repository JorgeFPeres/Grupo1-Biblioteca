package com.mjv.grupo1.livraria.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mjv.grupo1.livraria.exception.config.BusinessException;
import com.mjv.grupo1.livraria.model.client.Endereco;

@RestController
public class ViaCepController {

	@GetMapping(value = "/getCep/{cep}")
	public Endereco obterEndereco(@PathVariable(name = "cep") String cep) {

		RestTemplate restTemplate = new RestTemplate();

		String uri = "http://viacep.com.br/ws/{cep}/json/";

		Endereco endereco = restTemplate.getForObject(uri, Endereco.class, cep);
		
		if (endereco == null)
			throw new BusinessException("Endereço não localizado.");
			
		return endereco;
	}

}