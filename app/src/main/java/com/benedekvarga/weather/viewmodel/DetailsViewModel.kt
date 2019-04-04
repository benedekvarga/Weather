package com.benedekvarga.weather.viewmodel

import androidx.lifecycle.ViewModel
import com.benedekvarga.weather.model.model.City
import com.benedekvarga.weather.model.model.WeatherData
import com.benedekvarga.weather.model.repository.Repository
import com.benedekvarga.weather.model.repository.RepositoryImp
import io.reactivex.subjects.BehaviorSubject
import timber.log.Timber

class DetailsViewModel(val repository: Repository): ViewModel() {
}