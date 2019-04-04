package com.benedekvarga.weather.model.model

import java.util.*

data class WeatherData(
    val temperature: Double,
    val condition: String,
    val windSpeed: Double,
    val humidity: Double,
    val date: Date
)