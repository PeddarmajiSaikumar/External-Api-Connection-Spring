package com.ust.fetchdatafromapi.controller;

import com.ust.fetchdatafromapi.forecast.WeatherData;
import com.ust.fetchdatafromapi.response.SearchByMeal;
import com.ust.fetchdatafromapi.service.ApiCallerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class MealController {
    private final ApiCallerService apiCallerService;

    // GET /api/v1/meals/search?name=chicken
//    @GetMapping("/search")
//    public ResponseEntity<SearchByMeal> searchMealByName(@RequestParam("name") String name) {
//        return ResponseEntity.ok(apiCallerService.searchMealByName(name));
//    }

    @GetMapping("/forecast")
    public ResponseEntity<WeatherData> getWeatherData(
            @RequestParam("latitude") double latitude,
            @RequestParam("longitude") double longitude,
            @RequestParam("hourly") String hourly
    ) {
        return ResponseEntity.ok(apiCallerService.getWeatherData(latitude, longitude, hourly));
    }

    // GET /api/v1/meals/{id}

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
