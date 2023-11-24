CREATE TABLE foi_util (
	id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	id_pessoa BIGINT NOT NULL,
	id_ferramenta BIGINT NOT NULL,
	resposta VARCHAR(1) NOT NULL,
    FOREIGN KEY (id_pessoa) REFERENCES pessoa(id),
    FOREIGN KEY (id_ferramenta) REFERENCES ferramenta(id)
);