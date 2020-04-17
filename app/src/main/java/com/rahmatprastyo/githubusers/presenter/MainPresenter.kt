package com.rahmatprastyo.githubusers.presenter

import com.rahmatprastyo.githubusers.helper.NetworkProvider
import com.rahmatprastyo.githubusers.model.MainResponse
import com.rahmatprastyo.githubusers.service.MainDatasource
import com.rahmatprastyo.githubusers.view.MainView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(private val view: MainView) {


    fun discoverUsers(keyword: String) {
        view.onShowLoading()

        val dataSource = NetworkProvider.providesHttpAdapter().create(MainDatasource::class.java)

        dataSource.discoverUser(keyword).enqueue(object : Callback<MainResponse> {
            override fun onResponse(call: Call<MainResponse>, response: Response<MainResponse>) {
                view.onHideLoading()
                view.showToast(response)
            }

            override fun onFailure(call: Call<MainResponse>, t: Throwable) {
                view.onHideLoading()//untuk menghilangkan progressbar
                view.onFailure(t)//untuk memunculkan error
            }
        })
    }

}