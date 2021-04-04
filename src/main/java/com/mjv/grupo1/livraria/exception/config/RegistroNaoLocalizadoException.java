package com.mjv.grupo1.livraria.exception.config;

public class RegistroNaoLocalizadoException extends BusinessException {
	
	public RegistroNaoLocalizadoException(String titulo) {
		super("Exemplar não localizado pelo Titulo %s ", titulo);
	}
	
	public RegistroNaoLocalizadoException(String entidade, Object id) {
		super("%s não localizado pelo Id %s ", entidade, id.toString());
	}
	
}