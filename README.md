# Biblia Online API

API Rest Spring boot com Java e JPA, banco de dados H2 no profile de test e MySQL profile dev e prod.

## Objetivo 

Disponibilizar API simple da bibia versão nvi

## Base de Dados

Utilize o script do arquivo "create.sql" para subir a base em produção, importações profile de test e dev "src/main/resource/import.sql"

Profile de dev criar database bibia_online no MySQL
```sql
create database bibia_online;
```

## Fonte de Dados

O script SQL conseguir no projeto GitHUB [thiagobodruk](https://github.com/thiagobodruk/biblia)

## Endpoints
* /v1/testament
* /v1/books
* /v1/verses

Testes através do [Postman](https://www.postman.com/) colletion disponivel no arquivo "Biblia Online.postman_collection.json"

## Funções da API
* Buscar todos testament
* Buscar testament por id
* Buscar todos books
* Buscar books por id
* Buscar books por testament
* Buscar verses testament
* Buscar verses por id
* Buscar verses por testament
* Buscar verses por testament e book
* Buscar verses por testament, book e chapter
* Buscar Charpters por Testament e book