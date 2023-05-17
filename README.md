# Projeto de Cadastro e Venda de Livros

Este é um projeto desenvolvido em Java utilizando o framework Spring Boot, juntamente com as tecnologias H2, JUnit, Mockito e SonarCloud. O objetivo principal do projeto é fornecer uma aplicação web para cadastrar e vender livros.

## Funcionalidades

O projeto oferece as seguintes funcionalidades:

- Cadastro de livros: permite que os usuários cadastrem informações sobre os livros, como título, autor, gênero, editora, ano de publicação, etc.
- Pesquisa de livros: possibilita a busca por livros com base em diferentes critérios, como título, autor, gênero, editora, etc.
- Venda de livros: permite que os usuários realizem a venda de livros cadastrados, registrando informações sobre o comprador, data da venda, preço, etc.

## Tecnologias Utilizadas

O projeto faz uso das seguintes tecnologias:

- **Spring Boot**: framework Java que simplifica o desenvolvimento de aplicativos, fornecendo uma configuração inicial e facilitando a criação de APIs REST.
- **H2**: um banco de dados em memória utilizado para armazenar os dados dos livros e vendas.
- **JUnit**: uma biblioteca de testes unitários para Java, utilizada para escrever testes automatizados e garantir a qualidade do código.
- **Mockito**: um framework de teste que permite a criação de objetos simulados (mocks) para isolar partes específicas do sistema durante os testes.
- **SonarCloud**: uma plataforma de análise estática de código que ajuda a identificar problemas e vulnerabilidades, garantindo a qualidade e a segurança do código-fonte.

## Pré-requisitos

Antes de executar o projeto, certifique-se de ter o seguinte ambiente configurado em sua máquina:

- JDK 8 ou superior
- Maven
- Git

## Instalação

Siga os passos abaixo para configurar e executar o projeto localmente:

1. Clone o repositório do projeto:

```
git clone https://github.com/seu-usuario/nome-do-repositorio.git
```

2. Navegue até o diretório raiz do projeto:

```
cd nome-do-repositorio
```

3. Compile o projeto utilizando o Maven:

```
mvn compile
```

4. Execute o projeto:

```
mvn spring-boot:run
```

5. Acesse a aplicação em seu navegador através da URL: `http://localhost:8080`

## Testes

O projeto inclui testes automatizados para garantir seu correto funcionamento. Para executar os testes, utilize o seguinte comando:

```
mvn test
```

## Análise Estática de Código

O SonarCloud foi utilizado para realizar uma análise estática do código-fonte do projeto. O relatório de análise pode ser visualizado na página do projeto no SonarCloud.

## Contribuição

Contribuições são bem-vindas! Se você encontrar algum problema ou tiver sugestões para melhorias, fique à vontade para abrir uma "issue" ou enviar um "pull request" no repositório do projeto.

## Licença

Este projeto está licenciado sob a [MIT License](https://opensource.org/licenses/MIT). Sinta-se à vontade para utilizar, modificar e distribuir o código-fonte conforme necessário.
