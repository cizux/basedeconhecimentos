package com.bcol.api.infrastructure.repository;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import com.bcol.api.domain.model.Ferramenta;
import com.bcol.api.domain.repository.FerramentaRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class FerramentaRepositoryImpl implements FerramentaRepository{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Ferramenta> todos() {
		return manager.createQuery("FROM Ferramenta", Ferramenta.class).getResultList();
	}

	@Override
	public Ferramenta buscar(Long id) {
		return manager.find(Ferramenta.class, id);
	}

	@Transactional
	@Override
	public Ferramenta salvar(Ferramenta ferramenta) {
		return manager.merge(ferramenta);
	}

	@Transactional
	@Override
	public void remover(Long ferramentaId) {
		
		Ferramenta ferramenta = buscar(ferramentaId);
		
		if(ferramenta == null) {
			throw new EmptyResultDataAccessException(1);
		}
		manager.remove(ferramenta);
		
	}

}
