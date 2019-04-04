package com.benedekvarga.weather.model.repository.database

import com.benedekvarga.weather.model.model.City

interface DataBase {
    fun getFavourites(result: (cities: List<City>) -> Unit)
}