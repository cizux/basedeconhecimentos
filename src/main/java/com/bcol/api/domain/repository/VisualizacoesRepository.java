package com.bcol.api.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcol.api.domain.model.Visualizacoes;

@Repository
public interface VisualizacoesRepository {

	List<Visualizacoes> todos();
	Visualizacoes buscar(Long id);
	Visualizacoes salvar(Visualizacoes visualizacoes);
	
	
}
