package com.liyiming.weatherforecasttest.net

import com.liyiming.weatherforecasttest.bean.LocationSearchBean
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ILocationSearchRequest {
    @GET("/api/location/search")
    fun getLocation(@Query("query")query: String): Observable<List<LocationSearchBean>>
}