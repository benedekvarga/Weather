package com.benedekvarga.weather.model.repository.database

import com.benedekvarga.weather.model.model.City

class DataBaseMock: DataBase {
    override fun getFavourites(result: (cities: List<City>) -> Unit) {
        val mockCity = City(id = "123r423r52t", name = "Budapest", isFavourite = true)
        result.invoke(arrayListOf(mockCity))
    }
}