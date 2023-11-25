package com.bcol.api.infrastructure.repository;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bcol.api.domain.model.Pessoa;
import com.bcol.api.domain.repository.PessoaRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class PessoaRepositoryImpl implements PessoaRepository{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Pessoa> todos(){
		return manager.createQuery("SELECT p FROM Pessoa p", Pessoa.class).getResultList();
	}

	@Override
	public Pessoa buscar(long id) {
		return manager.find(Pessoa.class, id);
	}

	@Transactional
	@Override
	public Pessoa salvar(Pessoa pessoa) {
		return manager.merge(pessoa);
	}

	@Transactional
	@Override
	public void remover(Long pessoaId) {
		Pessoa pessoa = buscar(pessoaId);
		
		if(pessoa == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		manager.remove(pessoa);
	}
	
}
