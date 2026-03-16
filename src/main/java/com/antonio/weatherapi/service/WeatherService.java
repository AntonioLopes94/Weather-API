package com.antonio.weatherapi.service;

import com.antonio.weatherapi.model.Location;
import com.antonio.weatherapi.model.Weather;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tools.jackson.databind.JsonNode;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@Service
public class WeatherService {
    @Cacheable(value = "weather", key = "#location.getCityName.trim().toLowerCase()")
    public Weather findWeatherByLocation(Location location) throws IOException, InterruptedException {
        String url = "https://api.open-meteo.com/v1/forecast?"
                +"&latitude=" + location.getLatitude()
                +"&longitude=" + location.getLongitude()
                +"&daily=temperature_2m_max,temperature_2m_min"
                +"&current=temperature_2m"
                +"&forecast_days=1";

        JsonNode jsonNode = ExternalApiService.getJsonNodeFromUrl(url);
        float temperatureMax = jsonNode.get("daily").get("temperature_2m_max").get(0).asFloat();
        float temperatureMin = jsonNode.get("daily").get("temperature_2m_min").get(0).asFloat();
        float temperatureActual = jsonNode.get("current").get("temperature_2m").asFloat();
        String cityName = location.getCityName();

        return new Weather(cityName,temperatureActual,temperatureMax,temperatureMin);
    }
}
