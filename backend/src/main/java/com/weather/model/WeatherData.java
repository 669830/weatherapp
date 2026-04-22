package com.weather.model;

public record WeatherData(
    String city,
    String country,
    double temp,
    double feelsLike,
    String description,
    String icon,
    int humidity,
    double windSpeed,
    int pressure
) {}
