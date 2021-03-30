package com.mjv.grupo1.Livraria.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import org.springframework.web.server.ResponseStatusException;
import com.mjv.grupo1.Livraria.model.Cadastro;
import com.mjv.grupo1.Livraria.repository.CadastroRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CadastroServices {
	
	@Autowired
	private CadastroRepository cadastroRepository;
	
	
	public List<Cadastro> listAll(){
        return cadastroRepository.findAll();
    }
	
	public Cadastro findById(Integer id){
        return cadastroRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "not Found"));
    }
	
	public Cadastro save(Cadastro cadastro) {
		
		return cadastroRepository.save(cadastro);
	}
	
	public void delete(Integer id) {
        cadastroRepository.delete(findById(id));
    }
	
//	public void replace(Cadastro cadastro) {
//		Cadastro savedCadastro = findById(cadastro.getId());
//		savedCadastro = 
//      cadastroRepository.save(savedCadastro);
//    }
}
