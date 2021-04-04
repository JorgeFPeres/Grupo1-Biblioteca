package com.mjv.grupo1.livraria.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mjv.grupo1.livraria.controller.ViaCepController;
import com.mjv.grupo1.livraria.dto.CadastroDto;
import com.mjv.grupo1.livraria.exception.config.BusinessException;
import com.mjv.grupo1.livraria.model.client.Cadastro;
import com.mjv.grupo1.livraria.model.client.Endereco;
import com.mjv.grupo1.livraria.repository.CadastroRepository;

@Service
//@RequiredArgsConstructor
public class CadastroServices {

	@Autowired
	private ViaCepController viaCepCtrl;
	
	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private CadastroRepository cadRepository;
	
	@Autowired
	private ModelMapper mapper;

	public Cadastro criarCadastro(CadastroDto dto) {
		Cadastro cadastro = new Cadastro();
		if (cadRepository.findByCpf(dto.getCpf()) == null) {
			cadastro = mapper.map(dto, Cadastro.class);
			Endereco endereco = viaCepCtrl.obterEndereco(dto.getCep());
			cadastro.setEndereco(endereco);
			save(cadastro);
		}else {
			throw new BusinessException("Usuário já cadastrado");
		}
		return cadastro;		
	}

	public Cadastro save(Cadastro cadastro) {
		String senhaCriptografada = encoder.encode(cadastro.getLogin().getSenha());
		cadastro.getLogin().setSenha(senhaCriptografada);

		return cadRepository.save(cadastro);
	}

	public void delete(String cpf) {
		cadRepository.delete(findByCpf(cpf));
	}
	
	public List<Cadastro> listAll() {
		return cadRepository.findAll();
	}

	public Cadastro findById(Integer id) {
		return cadRepository.findById(id).orElse(null);
	}
	
	public Cadastro findByCpf(String cpf) {
		return cadRepository.findByCpf(cpf);
	}

}
