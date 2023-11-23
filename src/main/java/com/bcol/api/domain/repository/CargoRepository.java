package com.bcol.api.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcol.api.domain.model.Cargo;



@Repository
public interface CargoRepository {
	
	List<Cargo> todos();
	Cargo buscar(Long id);
	Cargo salvar(Cargo cargo);
	void remover(Long cargoId);

}
