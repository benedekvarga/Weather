package com.benedekvarga.weather.model.repository.network

import com.benedekvarga.weather.model.model.City
import com.benedekvarga.weather.model.model.WeatherData
import java.util.*

class WeatherAPIMock: WeatherAPI {
    override fun searchWeatherQuery(query: String, result: (city: City) -> Unit, error: (String) -> Unit) {
    }

    override fun getWeather(city: City, result: (weather: WeatherData) -> Unit, error: (String) -> Unit) {
        val weather = WeatherData(
            temperature = 12.22,
            condition = "Overcast",
            humidity = 59.1,
            windSpeed = 19.2,
            date = Date()
        )
        result.invoke(weather)
    }
}