package com.benedekvarga.weather.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.benedekvarga.weather.R
import com.benedekvarga.weather.view.dashboard.DashboardFragment
import com.benedekvarga.weather.view.details.DetailsFragment
import com.benedekvarga.weather.view.utils.addFragmentToActivity
import com.benedekvarga.weather.view.utils.replaceFragmentToActivity
import com.benedekvarga.weather.viewmodel.DashboardViewModel
import org.jetbrains.anko.toast
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFragmentToActivity(supportFragmentManager, DashboardFragment.getInstance(), R.id.contentFrame)
    }

    fun showDetails(cityId: String) {
        replaceFragmentToActivity(supportFragmentManager, DetailsFragment.getInstance(cityId), R.id.contentFrame)
    }
}