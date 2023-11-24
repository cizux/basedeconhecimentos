package com.bcol.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcol.api.domain.model.Pessoa;
import com.bcol.api.infrastructure.repository.PessoaRepositoryImpl;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

	@Autowired
	private PessoaRepositoryImpl pessoaRepositoryImpl;

	
	@GetMapping
	public List<Pessoa> listar(){
		return pessoaRepositoryImpl.todos();
	}
	
	

///
	
	@GetMapping("/{pessoaId}")
	public ResponseEntity<Pessoa> buscar(@PathVariable Long pessoaId) {
	Pessoa pessoa =  pessoaRepositoryImpl.buscar(pessoaId);
	
	if (pessoa != null) {
		return ResponseEntity.ok(pessoa);
	}
	return ResponseEntity.notFound().build();	
	}

}
