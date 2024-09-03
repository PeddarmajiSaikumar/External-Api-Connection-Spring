package com.ust.fetchdatafromapi.service;

import com.ust.fetchdatafromapi.response.SearchByMeal;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
@RequiredArgsConstructor
public class ApiCallerService {

    private final RestClient restClient;

    // https://www.themealdb.com/api/json/v1/1/search.php?s=chicken
    public SearchByMeal searchMealByName(String meal) {
        return restClient.get()
                .uri("/search.php?s={meal}", meal)
                .retrieve()
                .body(SearchByMeal.class);
    }

}
