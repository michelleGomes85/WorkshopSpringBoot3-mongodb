
# Workshop MongoDB com Spring Boot

Este projeto é um exemplo de uma aplicação Spring Boot integrada com MongoDB. Ele inclui funcionalidades básicas para gerenciamento de usuários e postagens, além de pesquisa de postagens com filtros de texto e datas.

## Estrutura do Projeto

A estrutura do projeto é organizada em pacotes conforme abaixo:

- **com.michelleGomes.workshopmongo**
  - Contém a classe principal `WorkshopmongoApplication`.

- **com.michelleGomes.workshopmongo.config**
  - `Instantiation`: Classe de configuração para instanciar dados de exemplo no banco de dados.

- **com.michelleGomes.workshopmongo.domain**
  - `Post`: Classe de domínio que representa uma postagem.
  - `User`: Classe de domínio que representa um usuário.

- **com.michelleGomes.workshopmongo.dto**
  - `AuthorDTO`: DTO para representar o autor de uma postagem.
  - `CommentDTO`: DTO para representar comentários em uma postagem.
  - `UserDTO`: DTO para representar um usuário.

- **com.michelleGomes.workshopmongo.repository**
  - `PostRepository`: Interface de repositório para `Post`.
  - `UserRepository`: Interface de repositório para `User`.

- **com.michelleGomes.workshopmongo.resources**
  - `PostResource`: Controlador REST para `Post`.
  - `UserResource`: Controlador REST para `User`.

- **com.michelleGomes.workshopmongo.resources.exception**
  - `ResourceExceptionHandler`: Manipulador de exceções para os recursos REST.
  - `StandardError`: Classe que representa o formato padrão de erro.

- **com.michelleGomes.workshopmongo.resources.util**
  - `URL`: Classe utilitária para manipulação de URLs e conversão de datas.

- **com.michelleGomes.workshopmongo.services**
  - `PostService`: Serviço para manipulação de `Post`.
  - `UserService`: Serviço para manipulação de `User`.

- **com.michelleGomes.workshopmongo.services.exception**
  - `ObjectNotFoundException`: Exceção personalizada para objeto não encontrado.

## Funcionalidades

### Usuários

- **Listar todos os usuários**: `GET /users`
- **Buscar usuário por ID**: `GET /users/{id}`
- **Inserir um novo usuário**: `POST /users`
- **Deletar um usuário**: `DELETE /users/{id}`
- **Atualizar um usuário**: `PUT /users/{id}`
- **Buscar postagens de um usuário**: `GET /users/{id}/posts`

### Postagens

- **Buscar postagem por ID**: `GET /posts/{id}`
- **Buscar postagens por título**: `GET /posts/titlesearch?text={text}`
- **Buscar postagens com filtro completo**: `GET /posts/fullsearch?text={text}&minDate={minDate}&maxDate={maxDate}`

## Configuração

1. **Clonar o repositório:**
    ```sh
    git clone https://github.com/seu-usuario/WorkshopSpringBoot3-mongodb.git
    ```

2. **Navegar até o diretório do projeto:**
    ```sh
    cd workshopmongo
    ```

3. **Configurar o MongoDB:**
    - Certifique-se de que você tem o MongoDB instalado e em execução na sua máquina.

4. **Executar a aplicação:**
    ```sh
    ./mvnw spring-boot:run
    ```

A aplicação estará disponível em `http://localhost:8080`.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **MongoDB**
- **Maven**

## Licença / Autor

[![NPM](https://img.shields.io/npm/l/react)](https://github.com/michelleGomes85/WorkshopSpringBoot3-mongodb/blob/main/LICENSE) 
[![GitHub](https://img.shields.io/badge/GitHub-000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/michellegomes85)
