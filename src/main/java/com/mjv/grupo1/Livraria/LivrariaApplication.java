package com.mjv.grupo1.Livraria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LivrariaApplication {
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
