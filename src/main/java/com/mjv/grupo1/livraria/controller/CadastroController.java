package com.mjv.grupo1.livraria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mjv.grupo1.livraria.dto.CadastroDto;
import com.mjv.grupo1.livraria.model.Cadastro;
import com.mjv.grupo1.livraria.services.CadastroServices;

@RequestMapping(path = "/cadastros")
@RestController
public class CadastroController {
	
	@Autowired
	private CadastroServices cadastroServices;
	
	@PostMapping
	public ResponseEntity<Integer> salvar(@RequestBody CadastroDto body) {
		Cadastro cad=cadastroServices.criarCadastro(body);
		return new ResponseEntity<>(cad.getId(), HttpStatus.CREATED);
	}
	
	@GetMapping
    public ResponseEntity<List<Cadastro>> list(){
        return new ResponseEntity<>(cadastroServices.listAll(), HttpStatus.OK);
    }
}
