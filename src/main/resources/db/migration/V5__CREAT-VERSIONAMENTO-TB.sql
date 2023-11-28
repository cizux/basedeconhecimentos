CREATE TABLE versionamento (
	id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	id_pessoa BIGINT NOT NULL,
	id_ferramenta BIGINT NOT NULL,
	versao BIGINT NOT NULL,
	descricao VARCHAR(255) NOT NULL,
	create_at DATETIME NOT NULL,
	
    FOREIGN KEY (id_pessoa) REFERENCES pessoa(id),
    FOREIGN KEY (id_ferramenta) REFERENCES ferramenta(id)
);