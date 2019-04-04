package com.benedekvarga.weather.view.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.benedekvarga.weather.databinding.CityListItemBinding
import com.benedekvarga.weather.databinding.FragmentDashboardBinding
import com.benedekvarga.weather.viewmodel.DashboardViewModel
import io.reactivex.disposables.Disposable
import org.koin.android.ext.android.inject

class DashboardFragment : Fragment() {
    lateinit var dataBinding: FragmentDashboardBinding
    val viewModel: DashboardViewModel by inject()
    val cityAdapter = CityAdapter(arrayListOf())
    lateinit var disposable: Disposable

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dataBinding = FragmentDashboardBinding.inflate(inflater, container, false)
        disposable = viewModel.favouriteCities
            .map {
                it.map {item ->
                    Pair( item.first.name, item.second.temperature.toString())
                }
            }
            .subscribe { list ->
                cityAdapter.dataSetChange(list)
            }

        dataBinding.rvList.layoutManager = LinearLayoutManager(context)
        dataBinding.rvList.adapter = cityAdapter

        return dataBinding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        disposable.dispose()
    }

    companion object {
        fun getInstance() = DashboardFragment()
    }

    class CityViewHolder(val binding: CityListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(city: String, temperature: String) {
            binding.cityName = city
            binding.temperatureValue = temperature
            binding.executePendingBindings()
        }
    }

    class CityAdapter(var cities: List<Pair<String, String>>) : RecyclerView.Adapter<CityViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
            var listItemBinding = CityListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return CityViewHolder(listItemBinding)
        }

        override fun getItemCount(): Int {
            return cities.size
        }

        override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
            holder.bind(cities.get(position).first, cities.get(position).second)
        }

        fun dataSetChange(cities: List<Pair<String, String>>) {
            this.cities = cities
            notifyDataSetChanged()
        }
    }
}