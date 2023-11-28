package com.bcol.api.domain.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Versionamento {
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long versao;
	private LocalDateTime createAt;
	private String descricao;
	
	
	
	
	
	@ManyToOne
	@JoinColumn(name ="id_ferramenta", nullable = false)
	private Ferramenta ferramenta;
	
	@ManyToOne
	@JoinColumn(name ="id_pessoa", nullable = false)
	private Pessoa pessoa;
	


}
