# Catálogo de Vinhos

Backend REST de um catálogo de vinhos com um sommelier virtual. A aplicação consulta os vinhos armazenados no MariaDB e usa Spring AI com Ollama para responder a perguntas e recomendações com base nos itens disponíveis.

## Tecnologias

- Java 21
- Spring Boot 4
- Spring Web MVC e Spring Data JPA
- MariaDB
- Spring AI com Ollama
- Springdoc OpenAPI
- Maven

## Pré-requisitos

- JDK 21
- MariaDB em execução
- Ollama em execução e configurado com um modelo compatível com a aplicação

## Configuração

1. Crie o banco de dados `catalogo` no MariaDB.
2. Configure a conexão do banco no arquivo de propriedades do perfil desejado:
   - `src/main/resources/application-dev.properties` para desenvolvimento;
   - `src/main/resources/application-prod.properties` para produção.
3. Informe a URL JDBC, o usuário e a senha do banco. Não compartilhe nem versione credenciais.
4. Configure o Ollama e o modelo de chat conforme o ambiente. A aplicação usa a integração Spring AI Ollama.

O perfil `dev` está definido como padrão em `application.properties`. A aplicação usa a porta `8080` por padrão.

> **Atenção:** no perfil `dev`, `spring.sql.init.mode=always` executa `data.sql` ao iniciar. Esse script apaga os registros de `table_vinho` e insere o catálogo de exemplo. Não use esse perfil com dados que queira preservar.

## Executar

No Windows, a partir da raiz do projeto:

```powershell
.\mvnw.cmd spring-boot:run
```

Para executar os testes:

```powershell
.\mvnw.cmd test
```

Para empacotar a aplicação:

```powershell
.\mvnw.cmd clean package
```

O JAR gerado pode ser iniciado com:

```powershell
java -jar target\catalogo-0.0.1-SNAPSHOT.jar
```

## API

### Conversar com o sommelier

```http
GET /api/vinhos/chat?mensagem={mensagem}&sessionId={sessao}
```

- `mensagem` (obrigatório): pergunta ou pedido de recomendação.
- `sessionId` (opcional): identificador usado para manter o contexto da conversa; quando omitido, usa `default-user`.

Exemplo com PowerShell:

```powershell
Invoke-RestMethod -Uri "http://localhost:8080/api/vinhos/chat?mensagem=Quero%20um%20vinho%20tinto&sessionId=cliente-1"
```

Quando perguntado sobre disponibilidade ou recomendações, o sommelier consulta o catálogo e considera os nomes e preços retornados pelo banco.

A interface Swagger UI fica disponível em:

```text
http://localhost:8080/swagger-ui/index.html
```

## Dados do catálogo

Cada vinho contém nome, origem, tipo, uva, preço, harmonização, descrição, imagem e código do sistema. A busca do catálogo aceita filtros opcionais por tipo, uva e origem, com correspondência parcial sem distinção entre maiúsculas e minúsculas.

## Estrutura do projeto

```text
src/
├── main/
│   ├── java/com/jcm/catalogo/
│   │   ├── config/        # Ferramentas de consulta do catálogo para o assistente
│   │   ├── controller/    # Endpoints REST
│   │   ├── entities/      # Entidades e modelos de requisição/resposta
│   │   └── repositories/  # Acesso a dados
│   └── resources/         # Configurações e dados de exemplo
└── test/                  # Testes automatizados
```
