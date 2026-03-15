package com.antonio.weatherapi.controller;

import com.antonio.weatherapi.model.Location;
import com.antonio.weatherapi.model.Weather;
import com.antonio.weatherapi.service.LocationService;
import com.antonio.weatherapi.service.WeatherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static java.lang.IO.readln;

@RestController
@RequestMapping("/")
public class WeatherController {

    private final WeatherService weatherService = new WeatherService();
    private final LocationService locationService = new LocationService();

    @GetMapping("/{city}")
    public ResponseEntity<Weather> getWeather(@PathVariable String city) throws IOException, InterruptedException {
        String cityEncoded = URLEncoder.encode(city, StandardCharsets.UTF_8);
        Location location = locationService.findLocationByName(cityEncoded);
        Weather weather = weatherService.findWeatherByLocation(location);
        return ResponseEntity.ok(weather);
    }

}
