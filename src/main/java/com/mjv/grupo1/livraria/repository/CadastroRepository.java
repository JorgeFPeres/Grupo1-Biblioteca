package com.mjv.grupo1.livraria.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mjv.grupo1.livraria.model.client.Cadastro;

public interface CadastroRepository extends JpaRepository<Cadastro, Integer> {
	Cadastro findByLoginUsuario(String usuario);
	
	Cadastro findByNome(String nome);
	
	Cadastro findByCpf(String cpf);
}
