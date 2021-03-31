package com.mjv.grupo1.Livraria;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mjv.grupo1.Livraria.sample.ApplicationSample;

@SpringBootApplication
public class LivrariaApplication {
	/**
	 * @author gleys
	 */
	public static void main(String[] args) {
		SpringApplication.run(LivrariaApplication.class, args);
	}
	
//	@Bean
//	public CommandLineRunner run(ApplicationSample bean) throws Exception {
//		return args -> {
//			bean.criarCadastro();
//		};
//	}

}
