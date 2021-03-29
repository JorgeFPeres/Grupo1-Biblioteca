package com.mjv.grupo1.Livraria.repository;

import java.awt.List;
import java.util.HashMap;
import java.util.Map;

import com.mjv.grupo1.Livraria.model.Cadastro;

public class CadastroRepository {
	private Map<Integer, Cadastro> dados = new HashMap<Integer, Cadastro>();
	
	public void insert(Cadastro cadastro) {
		dados.put(dados.size()+1,cadastro);
	}
	public Cadastro select(Integer id) {
		return dados.get(id);
	}
	public void update(Cadastro cadastro) {
		Integer id = cadastro.getId();
		Cadastro dbCadastro = select(id);
		if(dbCadastro!=null) {
			dados.put(id, pessoa);
		}
	}
	public List<Cadastro> selectAll() {
		return new ArrayList<Cadastro>(dados.values());
	}
}
