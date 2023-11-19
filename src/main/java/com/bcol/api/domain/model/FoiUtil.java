package com.bcol.api.domain.model;

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
public class FoiUtil {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	// exemplo sim - não
	private String resposta;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Ferramenta ferramenta;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Pessoa pessoa;
	

}
