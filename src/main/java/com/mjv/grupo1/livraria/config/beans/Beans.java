package com.mjv.grupo1.livraria.config.beans;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
}