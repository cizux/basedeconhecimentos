package com.bcol.api.infrastructure.repository;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import com.bcol.api.domain.model.Visualizacoes;
import com.bcol.api.domain.repository.VisualizacoesRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class VisualizacoesRepositoryImpl implements VisualizacoesRepository{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Visualizacoes> todos() {
		return manager.createQuery("FROM Visualizacoes", Visualizacoes.class).getResultList();
	}

	@Override
	public Visualizacoes buscar(Long id) {
		return manager.find(Visualizacoes.class, id);
	}

	@Transactional
	@Override
	public Visualizacoes salvar(Visualizacoes visualizacoes) {
		return manager.merge(visualizacoes);
	}

}
