package com.antonio.weatherapi.service;

import com.antonio.weatherapi.model.Location;
import tools.jackson.databind.JsonNode;

import java.io.IOException;

public class LocationService {
   public Location findLocationByName(String cityName) throws IOException, InterruptedException {
        String url = "https://geocoding-api.open-meteo.com/v1/search?name=" + cityName + "&count=1&language=en&format=json";
        JsonNode geoApi = ExternalApiService.getJsonNodeFromUrl(url);

        float latitude = geoApi.get("results").get(0)
                .get("latitude").asFloat();
        float longitude = geoApi.get("results").get(0)
                .get("longitude").asFloat();

        return new Location(cityName,latitude,longitude);
    }
}
