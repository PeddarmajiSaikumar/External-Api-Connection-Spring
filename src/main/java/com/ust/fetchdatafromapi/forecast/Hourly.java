package com.ust.fetchdatafromapi.forecast;

import java.util.List;

public record Hourly(
        List<String> time,
        List<Double> temperature_2m
) {}
