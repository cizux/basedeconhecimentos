package com.bcol.api.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.bcol.api.domain.model.Pessoa;
import com.bcol.api.infrastructure.repository.PessoaRepositoryImpl;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepositoryImpl pessoaRepositoryImpl;
	
	public Pessoa salvar(Pessoa pessoa) {
		return pessoaRepositoryImpl.salvar(pessoa);
	}
	
	public void excluir(Long pessoaId) {
		pessoaRepositoryImpl.remover(pessoaId);
	}
}
