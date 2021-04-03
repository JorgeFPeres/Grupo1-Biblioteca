package com.mjv.grupo1.livraria.exception.config;

public class BusinessException extends RuntimeException {
	public BusinessException(String mensagem) {
		super(mensagem);
	}

	public BusinessException(String mensagem, Object... params) {
		super(String.format(mensagem, params));
	}

}
