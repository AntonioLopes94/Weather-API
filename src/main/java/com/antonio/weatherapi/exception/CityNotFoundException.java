package com.antonio.weatherapi.exception;

public class CityNotFoundException extends RuntimeException {
public CityNotFoundException(String cityName){
    super("Cidade não encontrada: " + cityName);
}
}
