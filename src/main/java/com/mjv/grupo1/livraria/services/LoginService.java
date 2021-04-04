package com.mjv.grupo1.livraria.services;

import java.util.Date;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mjv.grupo1.livraria.config.security.JWTConstants;
import com.mjv.grupo1.livraria.config.security.JWTUtils;
import com.mjv.grupo1.livraria.dto.Sessao;
import com.mjv.grupo1.livraria.exception.config.CampoObrigatorioException;
import com.mjv.grupo1.livraria.model.client.Cadastro;
import com.mjv.grupo1.livraria.model.client.Login;
import com.mjv.grupo1.livraria.repository.CadastroRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {

	@Autowired
	private CadastroRepository repository;
	
	@Autowired
	private PasswordEncoder encoder;

	public Sessao logar(Login login) throws LoginException {
		
		Cadastro usuario = repository.findByLoginUsuario(login.getUsuario());

		if(login.getUsuario().isEmpty())
			throw new CampoObrigatorioException("Usuario");
		
		if(usuario!=null) {
			
			boolean senhaOk = encoder.matches(login.getSenha(),usuario.getLogin().getSenha());
			
			if(senhaOk) {
				Sessao sessao = new Sessao();
				sessao.setLogin(login.getUsuario());
				
				sessao.setDataInicio(new Date(System.currentTimeMillis()));
				sessao.setDataFim(new Date(System.currentTimeMillis() + JWTConstants.TOKEN_EXPIRATION));
				
				String token= JWTUtils.creteToken(login.getUsuario(), sessao.getDataInicio(), sessao.getDataFim());
								
				sessao.setToken(token);
				return sessao;
			}else {
				throw new LoginException("Senha inválida.");
			}
			
			
		}throw new LoginException("Usuário não cadastrado.");
	}
}
