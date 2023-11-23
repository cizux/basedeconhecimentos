package com.bcol.api.infrastructure.repository;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bcol.api.domain.model.Classificacao;
import com.bcol.api.domain.repository.ClassificacaoRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class ClassificacaoRepositoryImpl implements ClassificacaoRepository{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Classificacao> todos() {
		return manager.createQuery("FROM Classificacao ", Classificacao.class).getResultList();
	}

	@Override
	public Classificacao buscar(Long id) {
		return manager.find(Classificacao.class, id);
	}

	@Transactional
	@Override
	public Classificacao salvar(Classificacao classificacao) {
		return manager.merge(classificacao);
	}

	@Transactional
	@Override
	public void remover(Long classificacaoId) {
		Classificacao classificacao = buscar(classificacaoId);
		
		if(classificacao == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		manager.remove(classificacao);
	}

	
}
