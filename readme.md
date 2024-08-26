<h3 align="center">
 <img src="src/main/resources/org/example/view/images/logo 1.png" alt="BiblioTech" width="450"></a>
  
  Projeto da disciplina EXA 805 - Algoritmos e Programação II
</h3>

<br>

## Tópicos ✅
1. [Objetivo](#Objetivo)
2. [Diagrama de Casos de Uso](#Diagrama-de-Casos-de-Uso)
3. [Diagrama de Classes](#Diagrama-de-Classes)
4. [Divisão dos pacotes](#Divisão-dos-pacotes)
5. [Classes DAO](#Classes-DAO)
6. [Exceções](#Exceções)
7. [Testes](#Testes)
8. [Construído com](#Construído-com)
9. [Equipe](#Equipe)

## Objetivo 📝
O objetivo desse problema foi construir um sistema de gerenciamento de uma biblioteca utilizando a linguagem Java e
a Programação Orientada a Objeto (POO). Nesse primeira etapa foram solicitadas o Diagrama de casos de Uso, o Diagrama de Classes, o padrão de 
projeto DAO e por fim, os testes de unidade e integração.
- Docs que contém anotações e decisões de projeto:
[PERSONAL DOCS](https://docs.google.com/document/d/1mNysGljSI1wn0CKSz9MCoo9DC_7ymS4rivhGJET128w/edit)
- Docs que contém a descrição e detalhamento do projeto:
[PROJECT DOCS](https://docs.google.com/document/d/1K5wVcqw1sJ4_HRGZKCJ5lyudzDCfvsqBEtBueskVJrQ/edit)

## Diagrama de Casos de Uso
![Diagrama de Casos de Uso](/diagrams/casos_de_uso.jpg)

## Diagrama de Classes
![Diagrama de Casos de Uso](/diagrams/diagrama_de_classes.jpg)

## Divisão dos pacotes 📦
- Model: Contém todas classes do sistema e métodos principais a serem usados.
- Test: Contém todos testes de unidades e integração dos DAO e suas classes.
- Exceptions: Contém as classes para construção de execeções personalizadas. 
- Dao: Contém as interfaces DAO e suas a implementação das interfaces DAO. 
- Outros: Interface CRUD (interface que contém a assinatura dos métodos CRUD) e Classe DAO.

## Classes DAO 🗂️
- As classes DAO (Data Access Object) são padrões de projeto amplamente usados em desenvolvimento de software para 
separar a lógica de acesso aos dados da lógica de negócios da aplicação. Elas desempenham um papel fundamental na 
camada de persistência de um aplicativo e são projetadas para encapsular as operações de leitura e gravação de dados. 
- Por isso, temos uma as Interfaces DAO que extende a Interface CRUD, e as classes DAOImpl, que implementam essa 
interface DAO.

## Exceções 📈
- Uma exceção é um evento anormal ou imprevisto que ocorre durante a execução de um programa. As exceções são usadas 
para lidar com situações que podem interromper o fluxo normal do programa e, quando não tratadas adequadamente, podem 
causar erros graves ou falhas no sistema. 
- Por isso, nessa parte inicial o foco foi no lançamento de exceções, exceções essas que seram tratadas posteriormente. 
O foco foi criar exceções personalizadas para serem usadas em situações do sistema que fosse interromper o código por 
conta de algum erro. 

## Testes 🧪
- Testes unitários são uma prática de teste de software na qual partes individuais do código, chamadas de unidades, são 
testadas isoladamente para garantir que funcionem corretamente. 
- Dessa forma, o foco dos nossos testes foram testar métodos essenciais para o funcionamento do código, por isso, 
métodos como os getters e setters não foram testados. E também, métodos simples como bloqueio de leitor, não foram 
testados. Alguns métodos foram repetidos no código, porém para uma melhor eficiência dos testes, priorizamos em testar 
o método apenas uma vez.

## Ferramentas utilizadas 🔧
* Linguagem de Programação Java
* JDK 20
* JavaFX 19.0.2.1
* Maven
* [IntelliJ IDEA Community](https://www.jetbrains.com/idea/download/) - IDE utilizado para codificação

## Equipe
[//]: equipe

<a href="https://github.com/naylane"><img src="https://avatars.githubusercontent.com/u/89545660?v=4" title="Naylane Ribeiro" width="100"></a>
<a href="https://github.com/sarinhasf"><img src="https://avatars.githubusercontent.com/u/143294885?v=4" title="Sara Ferreira" width="100" ></a>

[//]: equipe
