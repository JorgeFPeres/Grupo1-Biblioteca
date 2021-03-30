package com.mjv.grupo1.Livraria.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mjv.grupo1.Livraria.dto.CadastroDto;
import com.mjv.grupo1.Livraria.model.Cadastro;
import com.mjv.grupo1.Livraria.services.CadastroServices;

@RequestMapping(path = "/cadastro")
@RestController
public class CadastroController {
	
	@Autowired
	private CadastroServices cadastroServices;
	
	
	
	@PostMapping
	public ResponseEntity<Cadastro> salvar(@RequestBody CadastroDto dto) {
		Cadastro cadastro = cadastroServices.save(dto.transformaParaObjeto());
		return new ResponseEntity<>(cadastro, HttpStatus.CREATED);
	}
	
	@GetMapping
    public ResponseEntity<List<Cadastro>> list(){
        return new ResponseEntity<>(cadastroServices.listAll(), HttpStatus.OK);
    }
}
