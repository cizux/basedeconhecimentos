package com.bcol.api.domain.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bcol.api.domain.model.Comentario;



@Repository
public interface ComentarioRepository {
	
	List<Comentario> todos();
	Comentario buscar(Long id);
	Comentario salvar(Comentario comentario);
	void remover(Long comentarioId);

}
