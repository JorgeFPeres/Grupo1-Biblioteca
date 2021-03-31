package com.mjv.grupo1.Livraria.model;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
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
	@Embedded
	private Login login;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id", referencedColumnName = "id" ,nullable = false)
	//@Embedded
	private Endereco endereco;
	
	public Cadastro() {
    }
	
	public Cadastro(String nome, String email ) {
		this.email = email;
		this.nome = nome;
	}
	

	public Cadastro(Integer id, String cpf, String nome, String email, String telefone, String login, String senha,
			Endereco endereco) {
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
//		this.login = login;
//		this.senha = senha;
//		this.endereco = endereco;
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
	
	public void setLogin(Login login) {
		this.login = login;
	}
	public Login getLogin() {
		return login;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}