package com.mjv.grupo1.Livraria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mjv.grupo1.Livraria.dto.Sessao;
import com.mjv.grupo1.Livraria.model.Login;
import com.mjv.grupo1.Livraria.services.LoginService;

@RestController
@RequestMapping(path = "/login")
public class LoginController {
	@Autowired
	private LoginService service;
	@PostMapping
	public Sessao logar(@RequestBody Login login) {
		return service.logar(login);
	}
}