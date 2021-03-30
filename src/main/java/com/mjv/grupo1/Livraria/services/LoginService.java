package com.mjv.grupo1.Livraria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mjv.grupo1.Livraria.model.Login;
import com.mjv.grupo1.Livraria.repository.LoginRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {

	@Autowired
	private LoginRepository loginRepository;

	public boolean executarLogin(String login, String senha) {
		Login log = loginRepository.findByLogin(login);
		if (log.getLogin().equals(login) && log.getSenha().equals(senha))
			return true;
		return false;
	}

	public Login findByLogin(String login) {
		return loginRepository.findByLogin(login);
	}

//	public List<Cadastro> listAll() {
//	
//	}
//
//	public Cadastro findById(Integer id) {
//		
//	}
//
//	public Cadastro save(Cadastro cadastro) {
//
//		return loginRepository.save(cadastro);
//	}
//
//	public void delete(Integer id) {
//		loginRepository.delete(findById(id));
//	}

}
