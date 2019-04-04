package com.benedekvarga.weather.model.repository

import com.benedekvarga.weather.model.model.City
import com.benedekvarga.weather.model.model.WeatherData
import com.benedekvarga.weather.model.repository.database.DataBase
import com.benedekvarga.weather.model.repository.network.WeatherAPI
import io.reactivex.subjects.BehaviorSubject

class RepositoryImp(val dataBase: DataBase, val weatherApi: WeatherAPI): Repository {
    override fun favouriteCities(result: (List<City>) -> Unit) {
        dataBase.getFavourites { cities ->
            result.invoke(cities)
        }
    }

    override fun getWeatherData(city: City, result: (WeatherData) -> Unit, error: (String) -> Unit) {
        weatherApi.getWeather(city, {weather ->
            result.invoke(weather)
        }, { message ->
            error.invoke(message)
        })
    }
}