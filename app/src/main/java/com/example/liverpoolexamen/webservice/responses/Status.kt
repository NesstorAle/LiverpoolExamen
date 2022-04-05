package com.example.liverpoolexamen.webservice.responses


import com.google.gson.annotations.SerializedName

data class Status(
    @SerializedName("status")
    val status: String,
    @SerializedName("statusCode")
    val statusCode: Int
)