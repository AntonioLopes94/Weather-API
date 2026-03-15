package com.antonio.weatherapi.model;

public class Weather {
    String cityName;
    float actualTemperature;
    float maxTemperature;
    float minTemperature;

    public Weather(String cityName, float actualTemperature, float maxTemperature, float minTemperature) {
        this.cityName = cityName;
        this.actualTemperature = actualTemperature;
        this.maxTemperature = maxTemperature;
        this.minTemperature = minTemperature;
    }
    public String toString(){
        return "Atualmente em " + cityName
                + " estamos com a temperatura de "
                + actualTemperature+"°C"
                + " e as temperaturas máximas e mínimas são "
                + maxTemperature+"°C e " + minTemperature+"°C respectivamente";
    }

}