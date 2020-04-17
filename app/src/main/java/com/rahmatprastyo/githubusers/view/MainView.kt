package com.rahmatprastyo.githubusers.view

import com.rahmatprastyo.githubusers.model.MainResponse
import com.rahmatprastyo.githubusers.model.Result
import retrofit2.Response

interface MainView {

    fun showToast(response: Response<MainResponse>)

    //yang digunakan oleh progress bar
    fun onShowLoading()
    fun onHideLoading()

    //respon success hasil  dari gson yang kita butuhkan
    fun onResponse(results: List<Result>)

    //respon gagal hasil  dari gson yang kita butuhkan
    fun onFailure(error: Throwable)

}