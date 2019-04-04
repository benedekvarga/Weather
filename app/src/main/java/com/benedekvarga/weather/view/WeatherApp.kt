package com.benedekvarga.weather.view

import androidx.multidex.MultiDexApplication
import com.benedekvarga.weather.model.repository.Repository
import com.benedekvarga.weather.model.repository.RepositoryImp
import com.benedekvarga.weather.model.repository.database.DataBase
import com.benedekvarga.weather.model.repository.database.DataBaseMock
import com.benedekvarga.weather.model.repository.network.WeatherAPI
import com.benedekvarga.weather.model.repository.network.WeatherAPIMock
import com.benedekvarga.weather.viewmodel.DashboardViewModel
import org.koin.android.ext.android.startKoin
import org.koin.android.viewmodel.experimental.builder.viewModel
import org.koin.dsl.module.module

class WeatherApp: MultiDexApplication() {

    private val appModule = module("appModule") {
        factory<DataBase> { DataBaseMock() }
        factory<WeatherAPI> { WeatherAPIMock() }
        single<Repository> { RepositoryImp(get(), get()) }
        viewModel<DashboardViewModel>()
    }

    // First entry point
    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(appModule))
    }
}