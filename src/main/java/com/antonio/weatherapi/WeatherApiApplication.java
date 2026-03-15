package com.antonio.weatherapi;

import com.antonio.weatherapi.model.Location;
import com.antonio.weatherapi.service.LocationService;
import com.antonio.weatherapi.service.WeatherService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static java.lang.IO.println;
import static java.lang.IO.readln;

@SpringBootApplication
public class WeatherApiApplication {
    public static void main(String[] args) throws IOException, InterruptedException {SpringApplication.run(WeatherApiApplication.class, args);

        WeatherService weatherService = new WeatherService();
        String city = URLEncoder.encode(readln(), StandardCharsets.UTF_8);

        final LocationService locationService = new LocationService();
        final Location location = locationService.findLocationByName(city);
        var weather = weatherService.findWeatherByLocation(location);
        println(weather.toString());


    }



}
