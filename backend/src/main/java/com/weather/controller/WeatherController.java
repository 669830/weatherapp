package com.weather.controller;

import com.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weather")
    public ResponseEntity<?> getWeather(@RequestParam String city) {
        try {
            return ResponseEntity.ok(weatherService.getWeather(city));
        } catch (HttpClientErrorException.NotFound e) {
            return ResponseEntity.status(404).body(Map.of("error", "City not found"));
        } catch (HttpClientErrorException.Unauthorized e) {
            return ResponseEntity.status(500).body(Map.of("error", "Invalid API key — check application.properties"));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Map.of("error", "Failed to fetch weather data"));
        }
    }
}
