package com.liyiming.weatherforecasttest.base

interface IBaseView {
    /*
     * When weather forecast load complete
     */
    fun loadComplete()

    /*
     * weather forecast load complete fails
     */
    fun loadFailure(error : String)
}