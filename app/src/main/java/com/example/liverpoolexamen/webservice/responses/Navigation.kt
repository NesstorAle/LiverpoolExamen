package com.example.liverpoolexamen.webservice.responses


import com.google.gson.annotations.SerializedName

data class Navigation(
    @SerializedName("ancester")
    val ancester: List<Ancester>,
    @SerializedName("childs")
    val childs: List<Any>,
    @SerializedName("current")
    val current: List<Current>
)