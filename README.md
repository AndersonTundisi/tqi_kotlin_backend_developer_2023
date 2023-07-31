# tqi_kotlin_backend_developer_2023

# Sistema de Autoatendimento da Mercearia do Bairro - JuMarket

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1.2-brightgreen) ![Kotlin](https://img.shields.io/badge/Kotlin-1.5.21-orange) ![Swagger](https://img.shields.io/badge/Swagger-3.0.0-blue)

## Descrição do Projeto

O Sistema de Autoatendimento da Mercearia do Bairro é uma aplicação desenvolvida em Spring Boot e Kotlin para automatizar o processo de compra em uma mercearia local. A aplicação permite que os clientes escolham os produtos, registrem suas compras e efetuem o pagamento de forma prática e rápida, sem depender de atendentes.

## Funcionalidades

- Cadastro e busca de categorias disponíveis na mercearia.
- Cadastro e busca de produtos disponíveis na mercearia.
- Registro e consulta de compras realizadas pelos clientes.
- Cálculo automático do valor total das compras.
- Opção de pagamento com cartão de crédito, débito, dinheiro ou Pix.

## Documentação da API

A documentação da API está disponível em tempo de execução através do Swagger. Para acessá-la, execute a aplicação e acesse a URL: `http://localhost:8080/swagger-ui/index.html`

## Requisitos

Certifique-se de ter o seguinte software instalado em sua máquina:

- Java Development Kit (JDK) 8 ou superior
- Docker (para executar o banco de dados MySQL via Docker)
- Docker Compose (O Docker-Compose deste projeto esta no diretrorio bd/)

## Executando a Aplicação

1. Clone o repositório para sua máquina local:

```
git clone https://github.com/AndersonTundisi/tqi_kotlin_backend_developer_2023.git
```

2. Acesse o diretório do projeto:

3. Inicie o banco de dados MySQL usando Docker Compose que está na pasta bd/ do projeto (ou execute o container do MySQL separadamente):

```
docker-compose up -d 
```

4. Inicie a aplicação Spring Boot:

```
./gradlew bootRun
```

5. Acesse a documentação da API pelo Swagger:

```
http://localhost:8080/swagger-ui/index.html
```

## Testando o Sistema

O Sistema de Autoatendimento pode ser testado através da documentação do Swagger, ou utilizando ferramentas como [Postman](https://www.postman.com/) ou [curl](https://curl.se/).

## Contribuindo

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues, enviar pull requests ou fornecer feedback sobre o projeto.

## Licença

Este projeto é para estudo e está disponivel para utilizar sem licença.

## Contato

Se você tiver alguma dúvida ou precisar de suporte, entre em contato através do email: astundisi@gmail.com
