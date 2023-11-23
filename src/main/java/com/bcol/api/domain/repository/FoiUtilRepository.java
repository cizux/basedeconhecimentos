package com.bcol.api.domain.repository;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcol.api.domain.model.FoiUtil;

@Repository
public interface FoiUtilRepository {

	List<FoiUtil> todos();
	FoiUtil buscar(Long id);
	FoiUtil salvar(FoiUtil foiUtil);
	void remover(Long FoiUtilId);
}
