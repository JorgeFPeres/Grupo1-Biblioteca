package com.mjv.grupo1.Livraria.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Login {

	@Column(nullable = false, unique = true, length = 20)
	private String login;
	@Column(nullable = false)
	private String senha;

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

	@Override
	public String toString() {
		return "Login login=" + login + "\nSenha=" + senha;
	}

}
