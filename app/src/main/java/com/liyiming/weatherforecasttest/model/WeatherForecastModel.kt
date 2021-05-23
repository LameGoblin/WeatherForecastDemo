package com.liyiming.weatherforecasttest.model

import android.annotation.SuppressLint
import android.util.Log
import com.liyiming.weatherforecasttest.base.BaseLoadListener
import com.liyiming.weatherforecasttest.bean.BaseBean
import com.liyiming.weatherforecasttest.bean.WeatherForecastBean
import com.liyiming.weatherforecasttest.net.ApiClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class WeatherForecastModel(private val cities: Array<String>): IWeatherForecastModel {
    private val tag: String = WeatherForecastModel::class.java.simpleName
    private var mDataList  = ArrayList<BaseBean<List<WeatherForecastBean>>>()

    @SuppressLint("CheckResult")
    override fun loadWeatherList(loadListener: BaseLoadListener<List<BaseBean<List<WeatherForecastBean>>>>) {
        val apiService = ApiClient().getApiService()
        val locationService = ApiClient().getLocationService()
        for (city in cities) {
            locationService!!.getLocation(city)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    Log.d(tag, "woeid = ${result[0].woeid}")
                    apiService!!.getWeatherForecast(result[0].woeid!!)
                        .subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({ result ->
                            mDataList.add(result)
                            Log.d(tag, "title = ${result.title}")
                            loadListener.loadSucess(mDataList)
                        }, {
                                error -> loadListener.loadFailure(error.message!!)
                        })
                }, {
                        error -> loadListener.loadFailure(error.message!!)
                })
        }
    }
}