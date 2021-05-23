package com.liyiming.weatherforecasttest.ui.adapter

import android.widget.ImageView
import androidx.databinding.ViewDataBinding
import com.liyiming.weatherforecasttest.BR
import com.liyiming.weatherforecasttest.R
import com.liyiming.weatherforecasttest.base.BaseViewHolder
import com.liyiming.weatherforecasttest.bean.BaseBean
import com.liyiming.weatherforecasttest.bean.WeatherForecastBean
import com.liyiming.weatherforecasttest.utils.loadImage

class WeatherForecastAdapter: BaseAdapter<BaseBean<List<WeatherForecastBean>>>() {
    private val mTomorrowIndex = 1;

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val binding: ViewDataBinding = holder.dataBinding
        val weatherForecast = data[position].consolidated_weather!![mTomorrowIndex]
        val url = "https://www.metaweather.com/static/img/weather/png/64/${weatherForecast.weather_state_abbr}.png"
        binding.setVariable(BR.basebean, data[position])
        binding.setVariable(BR.weatherforecast, weatherForecast)
        binding.setVariable(BR.max_temp, weatherForecast.max_temp!!.toInt().toString())
        binding.setVariable(BR.min_temp, weatherForecast.min_temp!!.toInt().toString())
        binding.setVariable(BR.wind_speed, weatherForecast.wind_speed!!.toInt().toString())
        binding.setVariable(BR.wind_direction_compass, weatherForecast.wind_direction_compass)
        binding.setVariable(BR.wind_direction_compass, weatherForecast.wind_direction_compass)
        binding.setVariable(BR.image_url, url)
        val imageView = ImageView(context)
        loadImage(imageView, url)
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.weather_forecast_item
    }
}