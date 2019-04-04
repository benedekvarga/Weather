package com.benedekvarga.weather.model.repository

import com.benedekvarga.weather.model.model.City
import com.benedekvarga.weather.model.model.WeatherData
import com.benedekvarga.weather.model.repository.database.DataBase
import com.benedekvarga.weather.model.repository.network.WeatherAPI
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject

class Repository(val dataBase: DataBase, val weatherApi: WeatherAPI) {
    var favouriteCities: BehaviorSubject<List<City>> = BehaviorSubject.create()

    init {
        favouriteCities
            .doOnSubscribe { t ->
                dataBase.getFavourites { cities ->
                    favouriteCities.onNext(cities)
                }
            }
    }

    fun getWeatherData(result: (city: City) -> WeatherData, error: (String) -> Unit = {}) {
        weatherApi.getWeather( { weather ->
            result.invoke(weather)
        }, { message ->
            error.invoke(message)
        })

    }
}