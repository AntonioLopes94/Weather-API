# Weather API Wrapper Service

Projeto desenvolvido como solução para o desafio **Weather API Wrapper Service** do [roadmap.sh](https://roadmap.sh/projects/weather-api-wrapper-service).

A aplicação recebe o nome de uma cidade, consulta APIs externas para obter a localização e a previsão do tempo, e retorna essas informações por meio de uma API própria construída com **Spring Boot**.

## Objetivo do desafio

O objetivo deste projeto é praticar:

- consumo de APIs de terceiros
- criação de uma API wrapper
- cache com expiração
- tratamento de erros
- uso de variáveis de ambiente
- rate limiting

## Tecnologias utilizadas

- **Java**
- **Spring Boot**
- **Spring Web**
- **Spring Cache**
- **Redis**
- **Bucket4j**
- **Jackson**
- **HTTP Client (Java)**

## Funcionalidades

- Buscar clima atual de uma cidade
- Buscar temperatura máxima e mínima do dia
- Consultar localização da cidade por geocoding
- Cachear resultados de localização e clima com Redis
- Limitar quantidade de requisições por IP
- Tratar erros de cidade não encontrada e falhas externas

## Como funciona

A aplicação segue este fluxo:

1. O usuário faz uma requisição informando o nome da cidade
2. A API consulta o serviço de geocoding da Open-Meteo para obter latitude e longitude
3. Com essas coordenadas, a aplicação consulta a API de forecast da Open-Meteo
4. O sistema retorna:
    - nome da cidade
    - temperatura atual
    - temperatura máxima
    - temperatura mínima

## Endpoint

### Buscar clima por cidade

```http
GET /{city}
------------------
GET /berlin
{
  "cityName": "berlin",
  "actualTemperature": 12.3,
  "maxTemperature": 15.8,
  "minTemperature": 6.4
}


---
https://roadmap.sh/projects/weather-api-wrapper-service

Reamed feito por IA