package com.bcol.api.infrastructure.repository;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bcol.api.domain.model.Cargo;
import com.bcol.api.domain.repository.CargoRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class CargoRepositoryImpl implements CargoRepository{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Cargo> todos() {
		return manager.createQuery("FROM Cargo", Cargo.class).getResultList();
	}

	@Override
	public Cargo buscar(Long id) {
		return manager.find(Cargo.class, id);
	}

	@Transactional
	@Override
	public Cargo salvar(Cargo cargo) {
		return manager.merge(cargo);
	}

	@Transactional                 	
	@Override
	public void remover(Long cargoId) {
		Cargo cargo = buscar(cargoId);
		
		if(cargo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		manager.remove(cargo);
	}

}
