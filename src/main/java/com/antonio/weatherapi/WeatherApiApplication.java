package com.antonio.weatherapi;

import com.antonio.weatherapi.model.Location;
import com.antonio.weatherapi.service.WeatherService;
import com.antonio.weatherapi.service.LocationService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

import static java.lang.IO.println;
import static java.lang.IO.readln;

@SpringBootApplication
public class WeatherApiApplication {
    public static void main(String[] args) throws IOException, InterruptedException {SpringApplication.run(WeatherApiApplication.class, args);

        String city = readln();

        final LocationService locationService = new LocationService();
        final Location location = locationService.findLocationByName(city);
        var weather = WeatherService.respostaClima(location);
        println(weather.toString());


    }



}
