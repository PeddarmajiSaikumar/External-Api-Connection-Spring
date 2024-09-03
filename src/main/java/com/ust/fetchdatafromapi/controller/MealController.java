package com.ust.fetchdatafromapi.controller;

import com.ust.fetchdatafromapi.response.SearchByMeal;
import com.ust.fetchdatafromapi.service.ApiCallerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/meals")
@RequiredArgsConstructor
public class MealController {
    private final ApiCallerService apiCallerService;

    // GET /api/v1/meals/search?name=chicken
    @GetMapping("/search")
    public ResponseEntity<SearchByMeal> searchMealByName(@RequestParam("name") String name) {
        return ResponseEntity.ok(apiCallerService.searchMealByName(name));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
