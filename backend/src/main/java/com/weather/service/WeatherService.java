package com.weather.service;

import com.weather.model.WeatherData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    private static final String API_URL =
        "https://api.openweathermap.org/data/2.5/weather?q={city}&appid={apiKey}&units=metric";

    @SuppressWarnings("unchecked")
    public WeatherData getWeather(String city) {
        Map<String, Object> raw = restTemplate.getForObject(API_URL, Map.class, city, apiKey);

        Map<String, Object> sys = (Map<String, Object>) raw.get("sys");
        Map<String, Object> main = (Map<String, Object>) raw.get("main");
        Map<String, Object> wind = (Map<String, Object>) raw.get("wind");
        Map<String, Object> weather = ((List<Map<String, Object>>) raw.get("weather")).get(0);

        double windKmh = Math.round(((Number) wind.get("speed")).doubleValue() * 3.6 * 10) / 10.0;

        return new WeatherData(
            (String) raw.get("name"),
            (String) sys.get("country"),
            ((Number) main.get("temp")).doubleValue(),
            ((Number) main.get("feels_like")).doubleValue(),
            (String) weather.get("description"),
            (String) weather.get("icon"),
            ((Number) main.get("humidity")).intValue(),
            windKmh,
            ((Number) main.get("pressure")).intValue()
        );
    }
}
