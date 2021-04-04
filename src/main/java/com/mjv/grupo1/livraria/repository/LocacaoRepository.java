package com.mjv.grupo1.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mjv.grupo1.livraria.model.sale.Locacao;

public interface LocacaoRepository extends JpaRepository<Locacao, Integer>{
	
	
	
}
