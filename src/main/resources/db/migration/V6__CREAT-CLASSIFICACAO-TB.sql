CREATE TABLE classificacao (
	id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	estrelas INTEGER(5) NULL,
	id_ferramenta BIGINT NOT NULL,
	id_pessoa BIGINT NOT NULL,
    FOREIGN KEY (id_pessoa) REFERENCES pessoa(id),
    FOREIGN KEY (id_ferramenta) REFERENCES ferramenta(id)
);