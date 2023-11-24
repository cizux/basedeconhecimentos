CREATE TABLE ferramenta (
	id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	id_software BIGINT NOT NULL,
	id_pessoa BIGINT NOT NULL,
	id_versao BIGINT NOT NULL,
	codigo_base_conhecimento VARCHAR(200) NOT NULL,
	titulo VARCHAR(255) NOT NULL,
	descricao VARCHAR(255) NOT NULL,
	pretencao VARCHAR(255) NOT NULL,
	causa VARCHAR(255) NOT NULL,
	procedimento TEXT NOT NULL,
    create_at DATETIME NOT NULL,
    update_at DATETIME NOT NULL,
	
    FOREIGN KEY (id_pessoa) REFERENCES pessoa(id),
    FOREIGN KEY (id_software) REFERENCES software(id),
    FOREIGN KEY (id_versao) REFERENCES versionamento(id)
);