package com.rahmatprastyo.githubusers.helper

import com.rahmatprastyo.githubusers.constant.Base
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkProvider {

    private fun providesHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().apply {
            retryOnConnectionFailure(true)
        }.build()
    }

    fun providesHttpAdapter(): Retrofit {
        return Retrofit.Builder().apply {
            client(providesHttpClient())
            baseUrl(Base.BASE_URL)
            addConverterFactory(GsonConverterFactory.create())
        }.build()
    }

}