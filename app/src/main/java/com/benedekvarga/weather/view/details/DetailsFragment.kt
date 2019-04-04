package com.benedekvarga.weather.view.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.benedekvarga.weather.databinding.FragmentDetailsBinding
import com.benedekvarga.weather.viewmodel.DetailsViewModel
import org.koin.android.ext.android.inject

class DetailsFragment: Fragment() {
    lateinit var dataBinding: FragmentDetailsBinding
    private val viewModel: DetailsViewModel by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBinding = FragmentDetailsBinding.inflate(inflater, container, false)
        return dataBinding.root
    }

    companion object {
        const val CITY_ID = "cityid"
        fun getInstance(cityId: String): DetailsFragment {
            val bundle = Bundle()
            bundle.putString(CITY_ID, cityId)

            val fragment = DetailsFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}