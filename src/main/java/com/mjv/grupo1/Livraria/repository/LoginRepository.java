package com.mjv.grupo1.Livraria.repository;

import org.springframework.data.repository.CrudRepository;
import com.mjv.grupo1.Livraria.model.Login;

public interface LoginRepository extends CrudRepository<Login, Integer> {

	public Login findByLogin(String login);

}
