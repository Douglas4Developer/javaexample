# Sistema de Projetos e Tarefas

Este é um sistema de gerenciamento de projetos e tarefas desenvolvido utilizando Java EE, Spring Framework, Hibernate, JSF, e RichFaces. 
O objetivo deste sistema é permitir a criação, edição e exclusão de projetos e tarefas associadas.

## Tecnologias Utilizadas

- Java EE 8 
- Spring Framework 5
- Hibernate 5
- JSF (JavaServer Faces)
- RichFaces
- MySQL

## Pré-requisitos

Antes de começar, certifique-se de ter as seguintes ferramentas instaladas em seu ambiente:

- JDK 8 ou superior
- Maven
- MySQL
- Tomcat 9 ou superior para configurar
- IntelliJ

## Configuração do Banco de Dados

1. Crie um banco de dados MySQL:
   ```sql
   CREATE DATABASE desafiojava;
   
username= root
senha= 326598

2. Execute o script SQL abaixo para criar as tabelas 
//SCRIPTS MYSQL
CREATE TABLE projeto (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    descricao TEXT,
    data_inicio DATE
);

CREATE TABLE tarefa (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    descricao TEXT,
    prioridade VARCHAR(50),
    estimativa_horas INT,
    projeto_id BIGINT,
    FOREIGN KEY (projeto_id) REFERENCES projeto(id)
);


## Clonando e Configurando o Projeto

1. Clone o repositório do GitHub:
    ```sh
    git clone https://github.com/seu-usuario/javaexample.git
    ```

2. Navegue até o diretório do projeto:
    ```sh
    cd javaexample
    ```

3. Compile o projeto usando Maven:
    ```sh
    mvn clean install
    ```

## Executando o Projeto

1. Implante o arquivo WAR no Tomcat:
    - Copie o arquivo `target/javaexample.war` para o diretório `webapps` do Tomcat.
    - Inicie o Tomcat (se não estiver iniciado).

2. Acesse o sistema através do navegador:
    ```sh
    http://localhost:8080/javaexample
    ```

## Funcionalidades

- **Cadastro de Projetos**: Permite a criação de novos projetos.
- **Edição de Projetos**: Permite a edição de projetos existentes.
- **Exclusão de Projetos**: Permite a exclusão de projetos, desde que não tenham tarefas associadas.
- **Visualização de Tarefas**: Permite visualizar as tarefas associadas a um projeto.
- **Cadastro de Tarefas**: Permite a criação de novas tarefas para um projeto.
- **Edição de Tarefas**: Permite a edição de tarefas existentes.
- **Exclusão de Tarefas**: Permite a exclusão de tarefas.

## Estrutura do Projeto

- `src/main/java/com/doug/javaexample/`
  - `controller/`: Contém os controladores do JSF.
  - `dao/`: Contém os DAOs para acesso ao banco de dados.
  - `entity/`: Contém as entidades JPA.
  - `service/`: Contém os serviços de negócio.
  - `utils/`: Contém utilitários como conversores.
- `src/main/resources/`
  - `application.properties`: Configurações do Spring.
- `src/main/webapp/`
  - `WEB-INF/`: Contém as configurações do JSF e arquivos de template.
  - `templates/`: Contém templates do JSF.
  - `resources/`: Contém recursos estáticos como CSS e imagens.

## Contribuição

1. Fork este repositório.


## Licença

Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## Contato

- Autor: Douglas Soares de Souza Ferreira
- Email: douglas8_ferreira@hotmail.com
- GitHub: https://github.com/Douglas4Developer

