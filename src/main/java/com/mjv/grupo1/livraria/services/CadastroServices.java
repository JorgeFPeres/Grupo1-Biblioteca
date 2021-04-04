package com.mjv.grupo1.livraria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mjv.grupo1.livraria.controller.ViaCepController;
import com.mjv.grupo1.livraria.dto.CadastroDto;
import com.mjv.grupo1.livraria.model.Cadastro;
import com.mjv.grupo1.livraria.model.Endereco;
import com.mjv.grupo1.livraria.repository.CadastroRepository;

@Service
//@RequiredArgsConstructor
public class CadastroServices {

	@Autowired
	private ViaCepController viaCepCtrl;
	
	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private CadastroRepository cadastroRepository;

	public List<Cadastro> listAll() {
		return cadastroRepository.findAll();
	}

	public Cadastro findById(Integer id) {
		return cadastroRepository.findById(id).orElse(null);
	}

	public Cadastro save(CadastroDto dto) {
		Cadastro cadastro = new Cadastro();
		cadastro.setCpf(dto.getCpf());
		cadastro.setEmail(dto.getEmail());
		cadastro.setLogin(dto.getLogin());
		cadastro.setNome(dto.getNome());
		cadastro.setTelefone(dto.getTelefone());
		Endereco endereco = viaCepCtrl.obterEndereco(dto.getCep());
		cadastro.setEndereco(endereco);
		return save(cadastro);
	}

	public Cadastro save(Cadastro cadastro) {
		String senhaCriptografada = encoder.encode(cadastro.getLogin().getSenha());
		cadastro.getLogin().setSenha(senhaCriptografada);

		return cadastroRepository.save(cadastro);
	}

	public void delete(Integer id) {
		cadastroRepository.delete(findById(id));
	}

}
