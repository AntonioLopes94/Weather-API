package com.antonio.weatherapi;

import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIController {
    public static void buscaLocalizacao(String localizacao) throws IOException, InterruptedException {
        String url = "https://geocoding-api.open-meteo.com/v1/search?name=" + localizacao + "&count=1&language=en&format=json";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(response.body());
        float latitude = jsonNode.get("results").get(0).get("latitude").asFloat();
        IO.println(latitude);


    }

}
