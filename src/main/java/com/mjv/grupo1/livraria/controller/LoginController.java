package com.mjv.grupo1.livraria.controller;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mjv.grupo1.livraria.dto.Sessao;
import com.mjv.grupo1.livraria.model.client.Login;
import com.mjv.grupo1.livraria.services.LoginService;

@RestController
@RequestMapping(path = "/login")
public class LoginController {
	@Autowired
	private LoginService service;
	@PostMapping
	public Sessao logar(@RequestBody Login login) throws LoginException {
		return service.logar(login);
	}
}