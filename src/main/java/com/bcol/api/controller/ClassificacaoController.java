package com.bcol.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bcol.api.domain.model.Cargo;
import com.bcol.api.domain.model.Classificacao;
import com.bcol.api.infrastructure.repository.ClassificacaoRepositoryImpl;

@RestController
@RequestMapping("classificacao")
public class ClassificacaoController {
	
	@Autowired
	private ClassificacaoRepositoryImpl classificacaoRepositoryImpl;
	
	
	@GetMapping
	public List<Classificacao> listar(){
		return classificacaoRepositoryImpl.todos();
	}

	@GetMapping("/{classificacaoid}")
	public ResponseEntity<Classificacao> buscar(@PathVariable Long classificacaoid) {
		Classificacao classificacao = classificacaoRepositoryImpl.buscar(classificacaoid);
		
		if (classificacao != null) {
			return ResponseEntity.ok(classificacao);
		}
		return ResponseEntity.notFound().build();	
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Classificacao adicionar(@RequestBody Classificacao classificacao) {
		return classificacaoRepositoryImpl.salvar(classificacao);
	}
	
	
	@PutMapping("/{classificacaoId}")
	public ResponseEntity<Classificacao> atualizar(@PathVariable Long classificacaoId, @RequestBody Classificacao classificacao){
		
		Classificacao classificacaoAtual = classificacaoRepositoryImpl.buscar(classificacaoId);
		
		if(classificacaoAtual != null) {	
		BeanUtils.copyProperties(classificacao, classificacaoAtual, "id");
		
		classificacaoRepositoryImpl.salvar(classificacaoAtual);
		
		return ResponseEntity.ok(classificacaoAtual);
		}
		
		return ResponseEntity.notFound().build();	
	}
	
	
	@DeleteMapping("/{classificacaoId}")
	public ResponseEntity<Cargo> remover(@PathVariable Long classificacaoId){
		
		try {
			Classificacao classificacao = classificacaoRepositoryImpl.buscar(classificacaoId);
		
			if(classificacao != null) {
			
				classificacaoRepositoryImpl.remover(classificacaoId);
			
		
				return ResponseEntity.noContent().build();
			}
		
			return ResponseEntity.notFound().build();
		
		} catch(DataIntegrityViolationException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
	
}
