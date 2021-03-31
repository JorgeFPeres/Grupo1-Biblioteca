package com.mjv.grupo1.Livraria.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mjv.grupo1.Livraria.model.Cadastro;

public interface CadastroRepository extends JpaRepository<Cadastro, Integer> {
	Cadastro findByLoginUsuario(String usuario);
}
