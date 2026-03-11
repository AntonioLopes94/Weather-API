package com.antonio.weatherapi;

import org.apache.http.client.utils.URIBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.util.UriBuilder;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

@SpringBootApplication
public class WeatherApiApplication {

    public static void main(String[] args) throws IOException, InterruptedException {SpringApplication.run(WeatherApiApplication.class, args);
        APIController.buscaLocalizacao("Nuremberg");
    }



}
