package com.benedekvarga.weather.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.benedekvarga.weather.R
import com.benedekvarga.weather.viewmodel.DashboardViewModel
import org.jetbrains.anko.toast
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val viewModel: DashboardViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.favouriteCities
            .subscribe { cities ->
                toast(cities.get(0).first.name)
            }
    }
}
