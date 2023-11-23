package com.bcol.api.infrastructure.repository;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bcol.api.domain.model.FoiUtil;
import com.bcol.api.domain.repository.FoiUtilRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class FoiUtilRepositoryImpl implements FoiUtilRepository{

	@PersistenceContext
	private EntityManager manager;
	
	
	@Override
	public List<FoiUtil> todos() {
		return manager.createQuery("FROM FoiUtil", FoiUtil.class).getResultList();
	}

	@Override
	public FoiUtil buscar(Long id) {
		return manager.find(FoiUtil.class, id);
	}
	
	@Transactional
	@Override
	public FoiUtil salvar(FoiUtil foiUtil) {
		return manager.merge(foiUtil);
	}

	@Transactional
	@Override
	public void remover(Long FoiUtilId) {
		FoiUtil foiUtil = buscar(FoiUtilId);
		
		if(foiUtil == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		manager.remove(foiUtil);
	}


}
