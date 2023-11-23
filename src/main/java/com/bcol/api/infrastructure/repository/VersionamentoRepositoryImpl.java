package com.bcol.api.infrastructure.repository;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import com.bcol.api.domain.model.Versionamento;
import com.bcol.api.domain.repository.VersionamentoRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class VersionamentoRepositoryImpl implements VersionamentoRepository{

	
	@PersistenceContext
	private EntityManager manager;
	

	@Override
	public List<Versionamento> todos() {
		return manager.createQuery("FROM Versionamento", Versionamento.class).getResultList();
	}

	@Override
	public Versionamento buscar(Long id) {
		return manager.find(Versionamento.class, id);
	}

	@Transactional
	@Override
	public Versionamento salvar(Versionamento versionamento) {
		return manager.merge(versionamento);
	}

	@Transactional
	@Override
	public void remover(Long versionamentoId) {
		Versionamento versionamento = buscar(versionamentoId);
		
		if(versionamento == null) {
			throw new EmptyResultDataAccessException(1);
		}
		manager.remove(versionamento);
		
	}

}
