package com.bcol.api.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcol.api.domain.model.Classificacao;



@Repository
public interface ClassificacaoRepository {
	
	List<Classificacao> todos();
	Classificacao buscar(Long id);
	Classificacao salvar(Classificacao classificacao);
	void remover(Long classificacaoId);

}