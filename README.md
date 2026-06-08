# design-patterns-pokedex-spring-boot

## Sobre o Projeto

Este projeto consiste em uma API simples de gerenciamento de treinadores e seus Pokémon.

A aplicação permite:

* Cadastrar treinadores;
* Associar Pokémon ao inventário de um treinador;
* Consultar treinadores cadastrados;
* Buscar automaticamente dados de Pokémon na PokéAPI quando eles não estiverem armazenados localmente.

Quando um Pokémon informado não existe no banco de dados, a aplicação realiza uma consulta à PokéAPI, salva as informações obtidas e as associa ao treinador.

---

## Tecnologias Utilizadas

* Java
* Spring Boot
* Spring Data JPA
* OpenFeign
* Swagger/OpenAPI
* PokéAPI

---

## Documentação da API

Após iniciar o servidor, acesse a documentação Swagger pelo endereço:

```text
http://127.0.0.1:8080/swagger-ui/index.html
```

---

## Exemplo de Requisição

JSON para cadastro de um treinador com seus Pokémon:

```json
{
  "nome": "Ash Ketchum",
  "pokemon": [
    {
      "id": 25
    },
    {
      "id": 1
    },
    {
      "id": 6
    }
  ]
}
```

### Resultado Esperado

Os Pokémon informados serão associados ao treinador:

| ID | Pokémon   |
| -- | --------- |
| 25 | Pikachu   |
| 1  | Bulbasaur |
| 6  | Charizard |

Caso algum deles não esteja presente no banco de dados, a aplicação buscará suas informações diretamente na PokéAPI.

---

## Executando o Projeto

Clone o repositório:

```bash
git clone [https://github.com/seu-usuario/design-patterns-pokedex-spring-boot.git](https://github.com/BielPatu/design-patterns-pokedex-spring-boot)
```

Acesse a pasta do projeto:

```bash
cd design-patterns-pokedex-spring-boot
```

Execute a aplicação:

```bash
mvn spring-boot:run
```

---

