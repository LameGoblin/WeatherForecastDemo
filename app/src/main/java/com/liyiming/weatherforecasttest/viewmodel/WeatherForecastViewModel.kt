package com.liyiming.weatherforecasttest.viewmodel

import android.content.Context
import com.liyiming.weatherforecasttest.R
import com.liyiming.weatherforecasttest.base.BaseLoadListener
import com.liyiming.weatherforecasttest.base.IBaseView
import com.liyiming.weatherforecasttest.bean.BaseBean
import com.liyiming.weatherforecasttest.bean.WeatherForecastBean
import com.liyiming.weatherforecasttest.model.IWeatherForecastModel
import com.liyiming.weatherforecasttest.model.WeatherForecastModel
import com.liyiming.weatherforecasttest.ui.adapter.WeatherForecastAdapter

class WeatherForecastViewModel(weatherForecastView: IBaseView, adapter: WeatherForecastAdapter, private val context: Context):
    BaseLoadListener<List<BaseBean<List<WeatherForecastBean>>>> {
    private var mWeatherForecastView: IBaseView = weatherForecastView
    private var mAdapter: WeatherForecastAdapter = adapter
    private var mWeatherForecastModel: IWeatherForecastModel? = null

    init {
        val cities = context.resources.getStringArray(R.array.cities)
        mWeatherForecastModel = WeatherForecastModel(cities)
        getWeatherForecast()
    }

    private fun getWeatherForecast() {
        mWeatherForecastModel!!.loadWeatherList(this)
    }

    override fun loadSucess(list: List<BaseBean<List<WeatherForecastBean>>>) {
        mAdapter.refreshData(list)
        mWeatherForecastView.loadComplete()
    }

    override fun loadFailure(error: String) {
        mWeatherForecastView.loadFailure(error)
    }
}