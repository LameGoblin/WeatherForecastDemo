package com.liyiming.weatherforecasttest.base

interface BaseLoadListener<T> {
    fun loadSucess(list: T)
    fun loadFailure(error: String)
}