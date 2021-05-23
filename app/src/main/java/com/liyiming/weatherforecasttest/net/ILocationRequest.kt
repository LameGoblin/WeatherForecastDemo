package com.liyiming.weatherforecasttest.net

import com.liyiming.weatherforecasttest.bean.BaseBean
import com.liyiming.weatherforecasttest.bean.WeatherForecastBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface ILocationRequest {
    @GET("/api/location/{woeid}")
    fun getWeatherForecast(@Path("woeid")woeid: Int): Observable<BaseBean<List<WeatherForecastBean>>>
}