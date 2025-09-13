# 🚘 Auto Escola ESPG - API REST
| Nome | RM |
|------|-----|
| Henrique Pontes Oliveira | RM98036 |
| Levy Nascimento Junior | RM98655 |
| Rafael Autieri dos Anjos | RM550885 |
| Rafael Carvalho Mattos | RM99874 |

API desenvolvida em **Spring Boot 3.5.4** com **MySQL 8** e **Flyway**, para gestão de **Instrutores** e **Alunos** de uma autoescola.  
Projeto acadêmico da disciplina **Arquitetura Orientada a Serviços e Web Services**.

---

## 📦 Tecnologias Utilizadas
- Java 21 (Amazon Corretto)
- Spring Boot 3.5.4
    - Spring Web
    - Spring Data JPA
    - Spring Validation
- MySQL 8
- Flyway (migrações automáticas)
- Swagger UI (documentação dos endpoints)
- Lombok (redução de boilerplate)

---

## ⚙️ Configuração do Ambiente

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/SpringBootProject3ESPG.git

Configure o banco MySQL:
```bash
CREATE DATABASE auto_escola_espg;
```
Ajuste o arquivo application.properties:
```
spring.datasource.url=jdbc:mysql://localhost:3306/auto_escola_espg
spring.datasource.username=root
spring.datasource.password=senha
spring.jpa.hibernate.ddl-auto=validate
spring.flyway.enabled=true
```
Acesse:

API: http://localhost:8080

Swagger: http://localhost:8080/swagger-u

## 📑 Endpoints
Health Check

GET /health-check
✅ Verifica se a API está online.
Resposta:

"API 3ESA OK!"
Instrutores

POST /instrutor
Cadastra um novo instrutor.
Exemplo Body:
```json
{
  "nome": "Carlos Silva",
  "email": "carlos@autoescola.com",
  "cnh": "5610073809",
  "especialidade": "MOTOS",
  "endereco": {
    "logradouro": "Rua das Flores",
    "numero": "123",
    "complemento": "Apto 45",
    "bairro": "Centro",
    "cidade": "São Paulo",
    "uf": "SP",
    "cep": "01000-000"
  }
}
```


GET /instrutor
Lista todos os instrutores.
Resposta:
```json
[
  {
    "id": 1,
    "nome": "Carlos Silva",
    "email": "carlos@autoescola.com",
    "especialidade": "MOTOS"
  }
]
```

🔹 Alunos

POST /alunos
Cadastra um novo aluno.
Exemplo Body:
```json
{
  "nome": "João Santos",
  "cpf": "123.456.789-10",
  "dataNascimento": "2000-05-10",
  "categoria": "A",
  "endereco": {
    "logradouro": "Av. Paulista",
    "numero": "1000",
    "complemento": "Bloco B",
    "bairro": "Bela Vista",
    "cidade": "São Paulo",
    "uf": "SP",
    "cep": "01310-100"
  },
  "instrutorId": 1
}
```

GET /alunos
Lista todos os alunos com paginação.
Parâmetros opcionais:

page (default = 0)

size (default = 10)

sort (ex: nome,asc)

Exemplo Resposta:
```
{
  "content": [
    {
      "id": 1,
      "nome": "João Santos",
      "cpf": "123.456.789-10",
      "categoria": "A",
      "instrutor": "Carlos Silva"
    }
  ],
  "pageable": { "pageNumber": 0, "pageSize": 10 }
}
```