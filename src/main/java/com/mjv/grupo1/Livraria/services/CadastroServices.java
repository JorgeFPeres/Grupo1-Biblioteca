package com.mjv.grupo1.Livraria.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mjv.grupo1.Livraria.model.Cadastro;
import com.mjv.grupo1.Livraria.repository.CadastroRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CadastroServices {
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private CadastroRepository cadastroRepository;
	
	
	public List<Cadastro> listAll(){
        return cadastroRepository.findAll();
    }
	
	public Cadastro findById(Integer id){
        return cadastroRepository.findById(id).orElse(null);
    }
	
	public Cadastro save(Cadastro cadastro) {
		String senhaCriptografada =encoder.encode(cadastro.getLogin().getSenha());
		cadastro.getLogin().setSenha(senhaCriptografada);
		
		return cadastroRepository.save(cadastro);
	}
	
	public void delete(Integer id) {
        cadastroRepository.delete(findById(id));
    }

}
