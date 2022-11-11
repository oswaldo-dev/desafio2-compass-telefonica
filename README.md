# desafio2-compass-telefonica

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)    ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) ![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)

>Esse projeto teve como objetivo o desenvolvimento do back-end de uma aplicação de microservice utilizando arquitetura hexagonal. Esta é uma api para consumir um micro serviço que possibilita a Criação de um produto, Atualização de um produto, Busca de um produto por Código, Lista de produtos, Lista de produtos filtrados por nome, descrição e preço e Deleção de um produto. 

## 💻 Requisitos

* O micro-serviço deverá ser desenvolvido com o padrão da arquitetura hexagonal.
* Deverão ser implementados testes unitários nesse micro-serviço.

## Endpoints existentes na aplicação:

| Verbo HTTP | Resource path                                                                | Description                 | Query param             |
| ---------- | ---------------------------------------------------------------------------- | --------------------------- | ----------------------- |  
|  POST      |	http://localhost:8080/productInventory/productManagement/v1/products				|	Criação de um produto       |                         |
|  PUT	     |	http://localhost:8080/productInventory/productManagement/v1/products/{id}		|	Atualização de um produto   |                         |
|  GET	     |	http://localhost:8080/productInventory/productManagement/v1/products/{id}		|	Busca de um produto por ID  |                         |
|  GET	     |	http://localhost:8080/productInventory/productManagement/v1/products				|	Lista de produtos           |                         |
|  GET	     |	http://localhost:8080/productInventory/productManagement/v1/products/search	|	Lista de produtos filtrados | q, min_price, max_price |
|  DELETE    |	http://localhost:8080/productInventory/productManagement/v1/products/{id}		|	Deleção de um produto       |                         |

## 📝 Payload
```
{
  "name" : "String",
  "description" : "String",
  "price" : Double
}
```

