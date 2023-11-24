CREATE TABLE visualizacoes (
	id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	id_pessoa BIGINT NOT NULL,
	id_ferramenta BIGINT NOT NULL,
	ip VARCHAR(45) NOT NULL,
	data_visualizacao DATETIME NOT NULL,
	quantidade_visualizacao_dia INT(4),
    FOREIGN KEY (id_pessoa) REFERENCES pessoa(id),
    FOREIGN KEY (id_ferramenta) REFERENCES ferramenta(id)
);