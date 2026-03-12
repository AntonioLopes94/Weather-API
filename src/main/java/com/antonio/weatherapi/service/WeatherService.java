package com.antonio.weatherapi.service;

import com.antonio.weatherapi.model.Location;
import com.antonio.weatherapi.model.Weather;
import tools.jackson.databind.JsonNode;

import java.io.IOException;

public class WeatherService {
    public Weather findWeatherByLocation(Location location) throws IOException, InterruptedException {
        String url = "https://api.open-meteo.com/v1/forecast?"
                +"&latitude=" + location.getLatitude()
                +"&longitude=" + location.getLongitude()
                +"&daily=temperature_2m_max,temperature_2m_min"
                +"&current=temperature_2m"
                +"&forecast_days=1";
        JsonNode jsonNode = ExternalApiService.getJsonNodeFromUrl(url);



        return new Weather();
    }
}
