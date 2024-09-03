package com.ust.fetchdatafromapi.forecast;


public record WeatherData(
        double latitude,
        double longitude,
        double generationtime_ms,
        int utc_offset_seconds,
        String timezone,
        String timezone_abbreviation,
        double elevation,
        HourlyUnits hourly_units,
        Hourly hourly
) {}




