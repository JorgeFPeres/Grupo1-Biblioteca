package com.mjv.grupo1.Livraria.dto;

import com.mjv.grupo1.Livraria.model.Cadastro;


import lombok.Getter;


@Getter
public class CadastroDto {
	
	private String nome;
	private String email;


	
	public Cadastro transformaParaObjeto(){
	    return new Cadastro(nome, email);
	}
}
 