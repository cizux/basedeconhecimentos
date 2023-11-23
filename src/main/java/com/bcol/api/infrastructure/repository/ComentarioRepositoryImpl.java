package com.bcol.api.infrastructure.repository;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bcol.api.domain.model.Comentario;
import com.bcol.api.domain.repository.ComentarioRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class ComentarioRepositoryImpl implements ComentarioRepository{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Comentario> todos() {
		return manager.createQuery("FROM Comentario", Comentario.class).getResultList();
	}

	@Override
	public Comentario buscar(Long id) {
		return manager.find(Comentario.class, id);
	}

	@Transactional
	@Override
	public Comentario salvar(Comentario comentario) {
		return manager.merge(comentario);
	}

	@Transactional
	@Override
	public void remover(Long comentarioId) {
		Comentario comentario = buscar(comentarioId);
		
		if(comentario == null) {
			throw new EmptyResultDataAccessException(1);
		}
		manager.remove(comentario);
	}

}
