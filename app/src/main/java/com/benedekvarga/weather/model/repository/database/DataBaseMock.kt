package com.benedekvarga.weather.model.repository.database

import com.benedekvarga.weather.model.model.City

class DataBaseMock: DataBase {
    override fun getCity(cityId: String): City = City(id = "123r", name = "Budapest", isFavourite = true)

    override fun insertFavourite(city: City) {
    }

    override fun removeFavourite(city: City) {
    }

    override fun getFavourites(result: (cities: List<City>) -> Unit) {
        result.invoke(arrayListOf(
            City(id = "123r", name = "Budapest", isFavourite = true),
            City(id = "1423r52t", name = "Praga", isFavourite = true),
            City(id = "123t", name = "View", isFavourite = true),
            City(id = "123r423", name = "New York", isFavourite = true),
            City(id = "23r52t", name = "Kazincbarcika", isFavourite = true),
            City(id = "1252t", name = "Miskolc", isFavourite = true)
        ))
    }
}