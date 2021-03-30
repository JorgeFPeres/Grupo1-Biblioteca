package com.mjv.grupo1.Livraria.services;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.mjv.grupo1.Livraria.model.Cadastro;

public class CadastroServices {
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
			dados.put(id, cadastro);
		}
	}
	public ArrayList<Cadastro> selectAll() {
		return new ArrayList<Cadastro>(dados.values());
	}
}
