package com.benedekvarga.weather.viewmodel

import androidx.lifecycle.ViewModel
import com.benedekvarga.weather.model.model.City
import com.benedekvarga.weather.model.model.WeatherData
import com.benedekvarga.weather.model.repository.Repository
import com.benedekvarga.weather.model.repository.RepositoryImp
import io.reactivex.subjects.BehaviorSubject
import timber.log.Timber

class DashboardViewModel(val repository: Repository): ViewModel() {

    val favouriteCities: BehaviorSubject<List<Pair<City, WeatherData>>> = BehaviorSubject.createDefault(arrayListOf())

    init {
        repository.favouriteCities { cities ->

            var cityList = arrayListOf<Pair<City, WeatherData>>()

            cities.forEach {city ->
                repository.getWeatherData(city, {weather ->
                    cityList.add(Pair(city, weather))
                }, {message ->
                    Timber.d(message)
                })
            }

            favouriteCities.onNext(cityList)
        }
    }
}