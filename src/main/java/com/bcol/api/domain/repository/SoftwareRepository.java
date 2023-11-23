package com.bcol.api.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcol.api.domain.model.Software;

@Repository
public interface SoftwareRepository {

	List<Software> todos();
	Software buscar(Long id);
	Software salvar(Software software);
	void remover(Long softwareId);
}
