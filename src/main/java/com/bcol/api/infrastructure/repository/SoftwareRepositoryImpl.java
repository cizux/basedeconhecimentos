package com.bcol.api.infrastructure.repository;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import com.bcol.api.domain.model.Software;
import com.bcol.api.domain.repository.SoftwareRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class SoftwareRepositoryImpl implements SoftwareRepository{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Software> todos() {
		return manager.createQuery("FROM Software", Software.class).getResultList();
	}

	@Override
	public Software buscar(Long id) {
		return manager.find(Software.class, id);
	}

	@Transactional
	@Override
	public Software salvar(Software software) {
		return manager.merge(software);
	}

	@Transactional
	@Override
	public void remover(Long softwareId) {
		Software software = buscar(softwareId);
		
		if(software == null) {
			throw new EmptyResultDataAccessException(1);
		}
		manager.remove(software);
	}

	
}
