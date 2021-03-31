package com.mjv.grupo1.livraria.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mjv.grupo1.livraria.config.security.JWTConstants;
import com.mjv.grupo1.livraria.config.security.JWTUtils;
import com.mjv.grupo1.livraria.dto.Sessao;
import com.mjv.grupo1.livraria.model.Cadastro;
import com.mjv.grupo1.livraria.model.Login;
import com.mjv.grupo1.livraria.repository.CadastroRepository;

@Service
//@RequiredArgsConstructor
public class LoginService {

	@Autowired
	private CadastroRepository repository;
	
	@Autowired
	private PasswordEncoder encoder;

	public Sessao logar(Login login) {
		Cadastro usuario = repository.findByLoginUsuario(login.getUsuario());
		if(usuario!=null) {
			
			boolean senhaOk = encoder.matches(login.getSenha(),usuario.getLogin().getSenha());
			
			if(senhaOk) {
				Sessao sessao = new Sessao();
				sessao.setLogin(login.getUsuario());
				
				Date inicio = new Date(System.currentTimeMillis());
				Date fim = new Date(System.currentTimeMillis() + JWTConstants.TOKEN_EXPIRATION);
				
				sessao.setDataInicio(inicio);
				sessao.setDataFim(fim);
				
				String token= JWTUtils.creteToken(login.getUsuario(), inicio, fim);
				
				sessao.setToken(token);
				return sessao;
			}else {
				throw new RuntimeException("Senha inválida");
			}
			
			
		}
		
		throw new RuntimeException("Login inválido");
	}
}
