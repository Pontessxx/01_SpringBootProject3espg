CREATE TABLE alunos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    data_nascimento DATE,
    categoria VARCHAR(10) NOT NULL,
    logradouro VARCHAR(120) NOT NULL,
    numero VARCHAR(20),
    complemento VARCHAR(50),
    bairro VARCHAR(60),
    cidade VARCHAR(60),
    uf VARCHAR(2),
    cep VARCHAR(10),
    instrutor_id BIGINT,
    CONSTRAINT fk_instrutor FOREIGN KEY (instrutor_id) REFERENCES instrutores(id)
);
