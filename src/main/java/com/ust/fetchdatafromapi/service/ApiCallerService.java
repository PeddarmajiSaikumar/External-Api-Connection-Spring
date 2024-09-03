package com.ust.fetchdatafromapi.service;

import com.ust.fetchdatafromapi.forecast.WeatherData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
@Service
@RequiredArgsConstructor
public class ApiCallerService {

    private final RestClient restClient;

    //https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&hourly=temperature_2m
    public WeatherData getWeatherData(double latitude, double longitude, String hourly) {
        return restClient.get()
                .uri("/forecast?latitude={latitude}&longitude={longitude}&hourly={hourly}",latitude,longitude,hourly)
                .retrieve()
                .body(WeatherData.class);
    }
}
