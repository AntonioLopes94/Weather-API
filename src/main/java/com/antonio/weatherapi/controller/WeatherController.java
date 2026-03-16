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

@RestController
@RequestMapping("/")
public class WeatherController {

    private final WeatherService weatherService;
    private final LocationService locationService;
    public WeatherController(WeatherService weatherService, LocationService locationService) {
        this.weatherService = weatherService;
        this.locationService = locationService;
    }

    @GetMapping("/{city}")
    public ResponseEntity<Weather> getWeather(@PathVariable String city) throws IOException, InterruptedException {
        Location location = locationService.findLocationByName(city);
        Weather weather = weatherService.findWeatherByLocation(location);
        return ResponseEntity.ok(weather);
    }

}
