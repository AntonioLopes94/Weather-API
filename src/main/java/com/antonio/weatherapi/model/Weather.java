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

    public String getCityName() {
        return cityName;
    }
    public float getActualTemperature() {
        return actualTemperature;
    }
    public float getMaxTemperature() {
        return maxTemperature;
    }
    public float getMinTemperature() {
        return minTemperature;
    }

}