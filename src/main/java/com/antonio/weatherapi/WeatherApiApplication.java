package com.antonio.weatherapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import java.io.IOException;

@SpringBootApplication
@EnableCaching
public class WeatherApiApplication {
    public static void main(String[] args) throws IOException, InterruptedException {SpringApplication.run(WeatherApiApplication.class, args);

    }



}
