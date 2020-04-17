package com.rahmatprastyo.githubusers.model

import com.google.gson.annotations.SerializedName

data class MainResponse(
    @SerializedName("items")
    val items: List<Result>
)

data class Result(
    @SerializedName("login")
    val login: String,

    @SerializedName("avatar_url")
    val avatarUrl: String
)