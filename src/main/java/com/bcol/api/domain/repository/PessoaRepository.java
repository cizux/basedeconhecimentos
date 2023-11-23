package com.bcol.api.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcol.api.domain.model.Pessoa;

@Repository
public interface PessoaRepository {
	
	List<Pessoa> todos();
	Pessoa buscar(long id);
	Pessoa salvar(Pessoa pessoa);
	void remover(Long pessoaId);

}
