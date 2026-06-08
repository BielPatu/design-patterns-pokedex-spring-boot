"# design-patterns-pokedex-spring-boot" 
Este projeto consiste em uma API simples de gerenciamento de treinadores e seus Pokémon. A aplicação permite cadastrar treinadores, associar Pokémon ao seu inventário e consultar as informações armazenadas.
Quando um Pokémon informado não está presente no banco de dados, a aplicação consulta a PokéAPI para obter seus dados e realiza o armazenamento automaticamente.


Ao iniciar o servidor use o Swagger  '127.0.0.1:8080/swagger-ui/index.html'

Exemplo de JSON basico para testar a API

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
