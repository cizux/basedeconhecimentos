package com.bcol.api.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcol.api.domain.model.Versionamento;

@Repository
public interface VersionamentoRepository {

	List<Versionamento> todos();
	Versionamento buscar(Long id);
	Versionamento salvar(Versionamento versionamento);
	void remover(Long versionamentoId);
}
