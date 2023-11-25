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
	
	@GetMapping("/{pessoaId}")
	public ResponseEntity<Pessoa> buscar(@PathVariable Long pessoaId) {
	Pessoa pessoa =  pessoaRepositoryImpl.buscar(pessoaId);
	
	if (pessoa != null) {
		return ResponseEntity.ok(pessoa);
	}
	return ResponseEntity.notFound().build();	
	}	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Pessoa adicionar(@RequestBody Pessoa pessoa) {
		return pessoaRepositoryImpl.salvar(pessoa);
	}
	
	@PutMapping("/{pessoaId}")
	public ResponseEntity<Pessoa> atualizar(@PathVariable Long pessoaId, @RequestBody Pessoa pessoa){
		
		Pessoa pessoaAtual = pessoaRepositoryImpl.buscar(pessoaId);
		
		if(pessoaAtual != null) {	
		BeanUtils.copyProperties(pessoa, pessoaAtual, "id");
		
		pessoaRepositoryImpl.salvar(pessoaAtual);
		
		return ResponseEntity.ok(pessoaAtual);
		}
		
		return ResponseEntity.notFound().build();	
	}
		
	@DeleteMapping("/{pessoaId}")
	public ResponseEntity<Pessoa> remover(@PathVariable Long pessoaId){
		
		try {
			Pessoa pessoa = pessoaRepositoryImpl.buscar(pessoaId);
		
			if(pessoa != null) {
			
				pessoaRepositoryImpl.remover(pessoaId);
			
		
				return ResponseEntity.noContent().build();
			}
		
			return ResponseEntity.notFound().build();
		
		} catch(DataIntegrityViolationException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
}
