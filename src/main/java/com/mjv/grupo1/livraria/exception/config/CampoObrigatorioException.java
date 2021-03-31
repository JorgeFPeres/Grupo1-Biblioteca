package com.mjv.grupo1.livraria.exception.config;

public class CampoObrigatorioException extends BusinessException {

	public CampoObrigatorioException(String campo) {
		super("Campo Obrigatório: " + campo);
	}

}
