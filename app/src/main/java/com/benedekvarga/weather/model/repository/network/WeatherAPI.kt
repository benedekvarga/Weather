package com.benedekvarga.weather.model.repository.network

import com.benedekvarga.weather.model.model.City
import com.benedekvarga.weather.model.model.WeatherData

interface WeatherAPI {
    fun getWeather(result: (city: City) -> WeatherData)
}