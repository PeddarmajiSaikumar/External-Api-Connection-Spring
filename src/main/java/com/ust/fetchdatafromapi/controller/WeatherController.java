package com.ust.fetchdatafromapi.controller;

import com.ust.fetchdatafromapi.forecast.WeatherData;
import com.ust.fetchdatafromapi.service.ApiCallerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class WeatherController {
    private final ApiCallerService apiCallerService;



    @GetMapping("/forecast")
    public ResponseEntity<WeatherData> getWeatherData(
            @RequestParam("latitude") double latitude,
            @RequestParam("longitude") double longitude,
            @RequestParam("hourly") String hourly
    ) {
        return ResponseEntity.ok(apiCallerService.getWeatherData(latitude, longitude, hourly));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
