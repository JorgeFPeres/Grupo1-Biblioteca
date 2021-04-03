package com.mjv.grupo1.livraria.services;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjv.grupo1.livraria.dto.LocacaoDto;
import com.mjv.grupo1.livraria.dto.LocacaoItemDto;
import com.mjv.grupo1.livraria.exception.config.RegistroNaoLocalizaoException;
import com.mjv.grupo1.livraria.model.Cadastro;
import com.mjv.grupo1.livraria.model.Livro;
import com.mjv.grupo1.livraria.model.Locacao;
import com.mjv.grupo1.livraria.model.LocacaoItem;
import com.mjv.grupo1.livraria.repository.CadastroRepository;
import com.mjv.grupo1.livraria.repository.LivroRepository;
import com.mjv.grupo1.livraria.repository.LocacaoRepository;



@Service
public class LocacaoService {
	@Autowired
	private LocacaoRepository repository;
	
	@Autowired
	private CadastroRepository cadRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	public void gerarLocacao(LocacaoDto dto) {
		Cadastro cad = cadRepository.findById(dto.getIdCadastro()).orElse(null);
		if(cad==null)
			throw new RegistroNaoLocalizaoException("Cadastro", dto.getIdCadastro());
		
		Locacao loc = new Locacao();
		
		loc.setDataAgendamento(dto.getDataAgendamento());
		loc.setCadastro(cad);
		loc.setDataRetirada(dto.getDataRetirada());
		
		for(LocacaoItemDto i: dto.getItens()) {
			i.getDataPrevisaoEntrega();
			
			Livro livro = livroRepository.findById(i.getIdLivro()).orElse(null);

			LocacaoItem item = new LocacaoItem();
			item.setLivro(livro);
			item.setDataPrevisaoEntrega(i.getDataPrevisaoEntrega());
			item.setValorDiaria(livro.getValorDiaria());
			item.setDiarias(calcularDiarias(loc.getDataRetirada(), i.getDataPrevisaoEntrega()));
			item.setValorLocacao(item.getValorDiaria() * item.getDiarias());
			
			loc.addItem(item);
			
			livro.incrementarReservado();
			
			livroRepository.save(livro);
		}
		
		repository.save(loc);
		
		
	
	}
	private Integer calcularDiarias(LocalDate dataRetirada, LocalDate dataPrevisaoEntrega) {
		Period period = Period.between(dataPrevisaoEntrega, dataRetirada);
	    int diff = Math.abs(period.getDays());
		return diff;
	}
}