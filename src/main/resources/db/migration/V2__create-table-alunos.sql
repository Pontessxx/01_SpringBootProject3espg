CREATE TABLE alunos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    data_nascimento DATE,
    categoria VARCHAR(10) NOT NULL,
    rua VARCHAR(255),
    numero VARCHAR(50),
    bairro VARCHAR(100),
    cidade VARCHAR(100),
    estado VARCHAR(50),
    cep VARCHAR(20),
    instrutor_id BIGINT,
    CONSTRAINT fk_instrutor FOREIGN KEY (instrutor_id) REFERENCES instrutores(id)
);
