package com.mjv.grupo1.Livraria.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@Table(name = "cadastro")
public class Cadastro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
//	@Column(nullable = false, unique = true, length = 11)
	private String cpf;
//	@Column(nullable = false)
	private String nome;
//	@Column(nullable = false)
	private String email;
//	@Column(nullable = false)
	private String telefone;
//	@Column(nullable = false, unique = true, length = 20)
	private String login;
//	@Column(nullable = false)
	private String senha;
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "endereco_id", referencedColumnName = "id" ,nullable = false)
//	private Endereco endereco;
	
	public Cadastro() {
    }
	
	public Cadastro(String nome, String email ) {
		this.email = email;
		this.nome = nome;
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}