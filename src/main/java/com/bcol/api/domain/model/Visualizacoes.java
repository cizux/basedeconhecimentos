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
public class Visualizacoes {
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String ip;
	private LocalDateTime dataVisualizacao;
	private Long quantidadeVisualizacao;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Pessoa pessoa;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Ferramenta ferramenta;

}
