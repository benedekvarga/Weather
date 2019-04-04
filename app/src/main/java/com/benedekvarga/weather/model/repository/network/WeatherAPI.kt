package com.benedekvarga.weather.model.repository.network

import com.benedekvarga.weather.model.model.City
import com.benedekvarga.weather.model.model.WeatherData

interface WeatherAPI {
    fun getWeather(city: City, result: (weather: WeatherData) -> Unit, error: (String) -> Unit)
}