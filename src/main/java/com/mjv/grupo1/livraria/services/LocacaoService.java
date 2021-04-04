package com.mjv.grupo1.livraria.services;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mjv.grupo1.livraria.dto.LocacaoDto;
import com.mjv.grupo1.livraria.dto.LocacaoItemDto;
import com.mjv.grupo1.livraria.exception.config.RegistroNaoLocalizadoException;
import com.mjv.grupo1.livraria.model.client.Cadastro;
import com.mjv.grupo1.livraria.model.library.DisponibilidadeStatus;
import com.mjv.grupo1.livraria.model.library.Livro;
import com.mjv.grupo1.livraria.model.sale.Locacao;
import com.mjv.grupo1.livraria.model.sale.LocacaoItem;
import com.mjv.grupo1.livraria.model.sale.LocacaoStatus;
import com.mjv.grupo1.livraria.repository.CadastroRepository;
import com.mjv.grupo1.livraria.repository.LivroRepository;
import com.mjv.grupo1.livraria.repository.LocacaoRepository;

@Service
public class LocacaoService {
	@Autowired
	private LocacaoRepository locRepository;

	@Autowired
	private CadastroRepository cadRepository;

	@Autowired
	private LivroRepository livroRepository;

	@Autowired
	private LivroService livroService;

	public void gerarLocacao(LocacaoDto dto) {
		Locacao locacao = preLocacao(dto);

		for (LocacaoItemDto i : dto.getItens()) {
			i.getDataPrevisaoEntrega();

			Livro livro = livroService.buscarLivro(i.getTitulo());

			if (livroService.verificarDisponibilidade(livro.getTitulo())) {
				LocacaoItem item = new LocacaoItem();
				item.setLivro(livro);
				item.setDataPrevisaoEntrega(i.getDataPrevisaoEntrega());
				item.setValorDiaria(livro.getValorDiaria());
				item.setDiarias(calcularDiarias(locacao.getDataRetirada(), item.getDataPrevisaoEntrega()));
				item.setValorLocacao(item.getValorDiaria() * item.getDiarias());
				locacao.addItem(item);
			}else {
				LocacaoItem item = new LocacaoItem();
				item.setLivro(livro);
				item.setStatus(DisponibilidadeStatus.INDISPONIVEL);
			}
				
//			livro.incrementarReservado();

			livroRepository.save(livro);
		}

		locRepository.save(locacao);

	}

	private Integer calcularDiarias(LocalDate dataRetirada, LocalDate dataPrevisaoEntrega) {
		Period period = Period.between(dataPrevisaoEntrega, dataRetirada);
		int diff = Math.abs(period.getDays());
		return diff;
	}

	// Cria uma locação pre configurada de acordo com as regras de negocio.
	private Locacao preLocacao(LocacaoDto dto) {
		Cadastro cadastro = cadRepository.findByCpf(dto.getCpf());
		if (cadastro == null)
			throw new RegistroNaoLocalizadoException("Cadastro", dto.getCpf());

		Locacao locacao = new Locacao();

		locacao.setDataAgendamento(dto.getDataAgendamento());
		locacao.setCadastro(cadastro);
		locacao.setDataRetirada(dto.getDataRetirada());
		locacao.setStatus(LocacaoStatus.RESERVADA);
		locacao.setValorTotal(0d);

		return locacao;
	}
}