package com.rahmatprastyo.githubusers.service

import com.rahmatprastyo.githubusers.model.MainResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MainDatasource {

    //get data url
    @GET("search/users")
    fun discoverUser(
        @Query("q")
        keyword: String
    ): Call<MainResponse>

}