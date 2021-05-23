package com.liyiming.weatherforecasttest.model

import com.liyiming.weatherforecasttest.base.BaseLoadListener
import com.liyiming.weatherforecasttest.bean.BaseBean
import com.liyiming.weatherforecasttest.bean.WeatherForecastBean

interface IWeatherForecastModel {
    fun loadWeatherList(loadListener: BaseLoadListener<List<BaseBean<List<WeatherForecastBean>>>>)
}