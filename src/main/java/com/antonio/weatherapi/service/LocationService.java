package com.antonio.weatherapi.service;

import com.antonio.weatherapi.exception.CityNotFoundException;
import com.antonio.weatherapi.model.Location;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tools.jackson.databind.JsonNode;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class LocationService {
    @Cacheable(value = "location", key = "#cityName.trim().toLowerCase()")
    public Location findLocationByName(String cityName) throws IOException, InterruptedException {
        String cityEncoded = URLEncoder.encode(cityName, StandardCharsets.UTF_8);
        String url = "https://geocoding-api.open-meteo.com/v1/search?name=" + cityEncoded + "&count=1&language=en&format=json";
        JsonNode geoApi = ExternalApiService.getJsonNodeFromUrl(url);

        if (geoApi == null || geoApi.isEmpty()) {
            throw new CityNotFoundException(cityName);
        }

        float latitude = geoApi.get("results").get(0)
                .get("latitude").asFloat();
        float longitude = geoApi.get("results").get(0)
                .get("longitude").asFloat();

        return new Location(cityName,latitude,longitude);
    }
}
