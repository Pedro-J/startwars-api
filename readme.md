# starwars-api

Implementação da API de Planets em Kotlin


## Configuração da Aplicação:

**Atenção**: 

- É necessário ter JAVA 8 ou mais instalado na sua máquina.
- A aplicação utiliza o gradle para gerenciar as dependêcias e build. 
- Os dados são salvos em um banco de dados em memória, com isso não é necessário o download de nenhum SGBD.
- A API faz chamadas HTTP para https://swapi.co/api/planets/ então é necessário estar conectado

## 1 - Instalação do Gradle e Dependências

Fazer o import do projeto em uma IDE, o projeto foi criado com Intellij, utilizando ele basta ir em "file -> open"
e seleciona o diretório desse projeto, ele baixará as dependências e plugins necessários de forma fácil e rápida.

## 2 - Execução da API 

```
$   cd {DIRETORIO_DO_PROJETO}
$   ./gradlew bootRun
```

## 3 - Criando novo planeta

```
$   curl -H "Content-Type: application/json" -d '{"name":"Endor","ground":"blue gound","weather":"COLD"}' -X POST http://localhost:8080/planets -w '\n'
```

## 4 - Buscando planeta por code

```
$   curl -H "Accept: application/json" -X GET http://localhost:8080/planets/{code} -w '\n'
```


## 5 - Buscando planeta por name

```
$   curl -H "Accept: application/json" -X GET http://localhost:8080/planets?name={name} -w '\n'
```

## 5 - Deletando planeta por code

```
$   curl -X DELETE http://localhost:8080/planets/{code} -w '\n'
```

