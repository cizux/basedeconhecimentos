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

import com.bcol.api.domain.model.Software;
import com.bcol.api.infrastructure.repository.SoftwareRepositoryImpl;

@RestController
@RequestMapping("/softwares")
public class SoftwareController {
	
	@Autowired
	private SoftwareRepositoryImpl softwareRepositoryImpl;
	
	
	@GetMapping
	public List<Software> listar(){
		return softwareRepositoryImpl.todos();
	}

	@GetMapping("/{softwareid}")
	public ResponseEntity<Software> buscar(@PathVariable Long softwareid) {
		Software software = softwareRepositoryImpl.buscar(softwareid);
		
		if (software != null) {
			return ResponseEntity.ok(software);
		}
		return ResponseEntity.notFound().build();	
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Software adicionar(@RequestBody Software software) {
		return softwareRepositoryImpl.salvar(software);
	}
	
	
	@PutMapping("/{softwareId}")
	public ResponseEntity<Software> atualizar(@PathVariable Long softwareId, @RequestBody Software software){
		
		Software softwareAtual = softwareRepositoryImpl.buscar(softwareId);
		
		if(softwareAtual != null) {	
		BeanUtils.copyProperties(software, softwareAtual, "id");
		
		softwareRepositoryImpl.salvar(softwareAtual);
		
		return ResponseEntity.ok(softwareAtual);
		}
		
		return ResponseEntity.notFound().build();	
	}
	
	
	@DeleteMapping("/{softwareId}")
	public ResponseEntity<Software> remover(@PathVariable Long softwareId){
		
		try {
			Software software = softwareRepositoryImpl.buscar(softwareId);
		
			if(software != null) {
			
				softwareRepositoryImpl.remover(softwareId);
			
		
				return ResponseEntity.noContent().build();
			}
		
			return ResponseEntity.notFound().build();
		
		} catch(DataIntegrityViolationException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
	
}
