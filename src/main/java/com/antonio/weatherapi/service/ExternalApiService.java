package com.antonio.weatherapi.service;

import org.springframework.stereotype.Service;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class ExternalApiService {
    static JsonNode getJsonNodeFromUrl(String url) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        ObjectMapper mapper = new ObjectMapper();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return mapper.readTree(response.body());
    }
}
