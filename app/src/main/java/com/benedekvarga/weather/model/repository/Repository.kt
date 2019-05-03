package com.benedekvarga.weather.model.repository

import com.benedekvarga.weather.model.model.City
import com.benedekvarga.weather.model.model.WeatherData

interface Repository {
    fun favouriteCities(result: (List<City>) -> Unit)
    fun getWeatherData(city: City, result: (WeatherData) -> Unit, error: (String) -> Unit)
    fun getCityById(cityId: String, result: (City) -> Unit, error: (String) -> Unit)
    fun getCityBySearchQuery(queryString : String, result: (City) -> Unit, error: (String) -> Unit)
    fun saveCityAsFavourite(city: City)
}