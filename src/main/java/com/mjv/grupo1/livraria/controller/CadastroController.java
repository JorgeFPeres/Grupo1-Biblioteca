package com.mjv.grupo1.livraria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mjv.grupo1.livraria.dto.CadastroDto;
import com.mjv.grupo1.livraria.model.client.Cadastro;
import com.mjv.grupo1.livraria.services.CadastroServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RequestMapping(path = "/cadastros")
@RestController
@Api("REST API Cadastros")
@CrossOrigin(origins = "*")
public class CadastroController {
	
	@Autowired
	private CadastroServices cadastroServices;
	
	@PostMapping("/cadastrar")
	@ApiOperation(value = "Cria um novo cadastro e persiste seus dados.")
	public ResponseEntity<Integer> salvar(@RequestBody CadastroDto body) {
		Cadastro cad=cadastroServices.criarCadastro(body);
		return new ResponseEntity<>(cad.getId(), HttpStatus.CREATED);
	}
	
	@GetMapping("/buscaporcpf")
	@ApiOperation(value = "Busca um cadastro através do cpf")
	public ResponseEntity<Cadastro> buscarCadastro(String cpf) {
		return new ResponseEntity<Cadastro>(cadastroServices.findByCpf(cpf), HttpStatus.OK);
	}
	
	@GetMapping("/listarcadastros")
	@ApiOperation(value = "Retorna uma lista de todos os cadastros")
    public ResponseEntity<List<Cadastro>> list(){
        return new ResponseEntity<>(cadastroServices.listAll(), HttpStatus.OK);
    }
	
	@DeleteMapping("/deletarcadastro")
	@ApiOperation(value = "Deleta um cadastro identificado pelo cpf")
	public void deletarCadastro(String cpf){
		cadastroServices.delete(cpf);
	}
}
