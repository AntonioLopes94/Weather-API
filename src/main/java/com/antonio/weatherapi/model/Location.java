package com.antonio.weatherapi.model;

import java.io.Serializable;

public class Location implements Serializable {
    private String cityName;
    private float latitude;
    private float longitude;

    public Location(String cityName,float latitude, float longitude){
        this.cityName = cityName;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public String getCityName() {
        return cityName;
    }
    public float getLatitude() {
        return latitude;
    }
    public float getLongitude() {
        return longitude;
    }
}
