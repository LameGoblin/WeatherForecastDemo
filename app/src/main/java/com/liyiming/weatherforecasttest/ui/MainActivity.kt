package com.liyiming.weatherforecasttest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.liyiming.weatherforecasttest.R
import com.liyiming.weatherforecasttest.base.IBaseView
import com.liyiming.weatherforecasttest.databinding.ActivityMainBinding
import com.liyiming.weatherforecasttest.ui.adapter.WeatherForecastAdapter
import com.liyiming.weatherforecasttest.viewmodel.WeatherForecastViewModel

class MainActivity : AppCompatActivity(), IBaseView {
    private val tag: String = MainActivity::class.java.simpleName
    private var mWeatherForecastVM: WeatherForecastViewModel? = null
    private var mAdapter: WeatherForecastAdapter? = null
    private var mBinding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initView()
        mWeatherForecastVM = WeatherForecastViewModel(this, mAdapter!!, this)
    }

    private fun initView() {
        val layoutManager = LinearLayoutManager(this)
        mBinding!!.rvWeatherForecast.layoutManager = layoutManager
        mAdapter = WeatherForecastAdapter()
        mBinding!!.rvWeatherForecast.adapter = mAdapter
    }

    override fun loadComplete() {
        Log.d(tag, "loadComplete")
    }

    override fun loadFailure(error: String) {
        Log.e(tag, "loadFailure: $error")
    }
}