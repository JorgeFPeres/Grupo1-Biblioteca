package com.mjv.grupo1.Livraria;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LivrariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LivrariaApplication.class, args);
	}
	@Bean
	public CommandLineRunner run(ApplicationSample as) throws Exception {
		return args -> {
			as.criarCadastro();
		};
	}

}
