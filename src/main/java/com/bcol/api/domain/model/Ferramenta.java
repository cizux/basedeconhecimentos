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
public class Ferramenta {
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_pessoa", nullable = false)
	private Pessoa pessoa;
	
	@ManyToOne
	@JoinColumn(name = "id_software",  nullable = false)
	private Software software;
	
	//Exemoplo - KBCode -> KB123456
	private String codigoBaseConhecimento;
	private String titulo;
	private String descricao;
	private LocalDateTime createAt;
	private LocalDateTime updateAt;
	private String pretencao;
	private String causa;
	private String procedimento;
	
}
