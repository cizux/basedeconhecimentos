package com.bcol.api.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcol.api.domain.model.Ferramenta;

@Repository
public interface FerramentaRepository {

	List<Ferramenta> todos();
	Ferramenta buscar(Long id);
	Ferramenta salvar(Ferramenta ferramenta);
	void remover(Long ferramentaId);
}
