package com.liyiming.weatherforecasttest.net

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient {
    private val mBaseUrl = "https://www.metaweather.com/"
    private val mDefaultTimeout: Long = 30

    private var retrofit: Retrofit? = null
    init {
        val client = OkHttpClient.Builder()
            .retryOnConnectionFailure(true)
            .connectTimeout(mDefaultTimeout, TimeUnit.SECONDS)
            .readTimeout(mDefaultTimeout, TimeUnit.SECONDS)
            .build()
        retrofit = Retrofit.Builder()
            .baseUrl(mBaseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    fun getApiService(): ILocationRequest? {
        return retrofit!!.create(ILocationRequest::class.java)
    }

    fun getLocationService():ILocationSearchRequest? {
        return retrofit!!.create(ILocationSearchRequest::class.java)
    }
}