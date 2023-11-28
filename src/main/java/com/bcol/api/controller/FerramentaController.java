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

import com.bcol.api.domain.model.Ferramenta;
import com.bcol.api.infrastructure.repository.FerramentaRepositoryImpl;

@RestController
@RequestMapping("/baseconhecimentos")
public class FerramentaController {
	
	@Autowired
	private FerramentaRepositoryImpl ferramentaRepositoryImpl;
	
	
	@GetMapping
	public List<Ferramenta> listar(){
		return ferramentaRepositoryImpl.todos();
	}

	@GetMapping("/{ferramentaid}")
	public ResponseEntity<Ferramenta> buscar(@PathVariable Long ferramentaid) {
		Ferramenta ferramenta = ferramentaRepositoryImpl.buscar(ferramentaid);
		
		if (ferramenta != null) {
			return ResponseEntity.ok(ferramenta);
		}
		return ResponseEntity.notFound().build();	
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Ferramenta adicionar(@RequestBody Ferramenta ferramenta) {
		return ferramentaRepositoryImpl.salvar(ferramenta);
	}
	
	
	@PutMapping("/{ferramentaId}")
	public ResponseEntity<Ferramenta> atualizar(@PathVariable Long ferramentaId, @RequestBody Ferramenta ferramenta){
		
		Ferramenta ferramentaAtual = ferramentaRepositoryImpl.buscar(ferramentaId);
		
		if(ferramentaAtual != null) {	
		BeanUtils.copyProperties(ferramenta, ferramentaAtual, "id");
		
		ferramentaRepositoryImpl.salvar(ferramentaAtual);
		
		return ResponseEntity.ok(ferramentaAtual);
		}
		
		return ResponseEntity.notFound().build();	
	}
	
	
	@DeleteMapping("/{ferramentaId}")
	public ResponseEntity<Ferramenta> remover(@PathVariable Long ferramentaId){
		
		try {
			Ferramenta ferramenta = ferramentaRepositoryImpl.buscar(ferramentaId);
		
			if(ferramenta != null) {
			
				ferramentaRepositoryImpl.remover(ferramentaId);
			
		
				return ResponseEntity.noContent().build();
			}
		
			return ResponseEntity.notFound().build();
		
		} catch(DataIntegrityViolationException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
	
}
