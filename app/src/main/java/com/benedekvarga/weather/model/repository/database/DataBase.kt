package com.benedekvarga.weather.model.repository.database

import com.benedekvarga.weather.model.model.City

interface DataBase {
    fun getFavourites(result: (cities: List<City>) -> Unit)
    fun getCity(cityId: String): City
    fun insertFavourite(city : City)
    fun removeFavourite(city: City)
}