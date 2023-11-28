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
import com.bcol.api.infrastructure.repository.CargoRepositoryImpl;

@RestController
@RequestMapping("/cargos")
public class CargoController {
	
	@Autowired
	private CargoRepositoryImpl cargoRepositoryImpl;
	
	
	@GetMapping
	public List<Cargo> listar(){
		return cargoRepositoryImpl.todos();
	}

	@GetMapping("/{cargoid}")
	public ResponseEntity<Cargo> buscar(@PathVariable Long cargoid) {
		Cargo cargo = cargoRepositoryImpl.buscar(cargoid);
		
		if (cargo != null) {
			return ResponseEntity.ok(cargo);
		}
		return ResponseEntity.notFound().build();	
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Cargo adicionar(@RequestBody Cargo cargo) {
		return cargoRepositoryImpl.salvar(cargo);
	}
	
	
	@PutMapping("/{cargoId}")
	public ResponseEntity<Cargo> atualizar(@PathVariable Long cargoId, @RequestBody Cargo cargo){
		
		Cargo cargoAtual = cargoRepositoryImpl.buscar(cargoId);
		
		if(cargoAtual != null) {	
		BeanUtils.copyProperties(cargo, cargoAtual, "id");
		
		cargoRepositoryImpl.salvar(cargoAtual);
		
		return ResponseEntity.ok(cargoAtual);
		}
		
		return ResponseEntity.notFound().build();	
	}
	
	
	@DeleteMapping("/{cargoId}")
	public ResponseEntity<Cargo> remover(@PathVariable Long cargoId){
		
		try {
			Cargo cargo = cargoRepositoryImpl.buscar(cargoId);
		
			if(cargo != null) {
			
				cargoRepositoryImpl.remover(cargoId);
			
		
				return ResponseEntity.noContent().build();
			}
		
			return ResponseEntity.notFound().build();
		
		} catch(DataIntegrityViolationException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
	
}
