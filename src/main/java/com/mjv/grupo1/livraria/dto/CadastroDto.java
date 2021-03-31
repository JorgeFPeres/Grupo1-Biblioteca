package com.mjv.grupo1.livraria.dto;

import com.mjv.grupo1.livraria.model.Cadastro;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class CadastroDto {
	
	private Integer id;
	private String nome;
	private String email;
	private String cpf;
	private String telefone;
	private String login;
	private String senha;

	public Cadastro transformaParaObjeto(){
	    return new Cadastro(nome, email);
	}
}
 