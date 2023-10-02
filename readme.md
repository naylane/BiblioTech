# Library Project 
### Alunas: Sara e Naylane 
### Classe: Algorithms 2

## Topics
1. Objetivo 
2. Divisão dos pacotes 
3. Classes DAO
4. Exceções
5. Testes

## Objetivo 
O objetivo desse problema foi construir um sistema de gerenciamento de uma biblioteca utilizando a linguagem java e
o método DAO. Nesse primeira estapa foram solicitadas o Diagrama de casos de Uso, o Diagrama de Classes, o padrão de 
projeto DAO e por fim, os testes de unidade e integração.
- Docs que contém anotações e decisões de projeto:
[PERSONAL DOCS](https://docs.google.com/document/d/1mNysGljSI1wn0CKSz9MCoo9DC_7ymS4rivhGJET128w/edit)
- Docs que contém a descrição e detalhamento do projeto
[PROJECT DOCS](https://docs.google.com/document/d/1K5wVcqw1sJ4_HRGZKCJ5lyudzDCfvsqBEtBueskVJrQ/edit)


## Divisão dos pacotes
- Model: Contém todas classes do sistema e métodos principais a serem usados.
- Test: Contém todos testes de unidades e integração dos DAO e suas classes.
- Exceptions: Contém as classes para construção de execeções personalizadas. 
- Dao: Contém as interfaces DAO e suas a implementação das interfaces DAO. 
- Outros: Interface CRUD (interface que contém a assinatura dos métodos CRUD) e Classe DAO.

## Classes DAO
- As classes DAO (Data Access Object) são padrões de projeto amplamente usados em desenvolvimento de software para 
separar a lógica de acesso aos dados da lógica de negócios da aplicação. Elas desempenham um papel fundamental na 
camada de persistência de um aplicativo e são projetadas para encapsular as operações de leitura e gravação de dados. 
- Por isso, temos uma as Interfaces DAO que extende a Interface CRUD, e as classes DAOImpl, que implementam essa 
interface DAO.

## Exceções
- Uma exceção é um evento anormal ou imprevisto que ocorre durante a execução de um programa. As exceções são usadas 
para lidar com situações que podem interromper o fluxo normal do programa e, quando não tratadas adequadamente, podem 
causar erros graves ou falhas no sistema. 
- Por isso, nessa parte inicial o foco foi no lançamento de exceções, exceções essas que seram tratadas posteriormente. 
O foco foi criar exceções personalizadas para serem usadas em situações do sistema que fosse interromper o código por 
conta de algum erro. 

## Testes 
