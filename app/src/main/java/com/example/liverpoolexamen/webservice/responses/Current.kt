package com.example.liverpoolexamen.webservice.responses


import com.google.gson.annotations.SerializedName

data class Current(
    @SerializedName("categoryId")
    val categoryId: String,
    @SerializedName("label")
    val label: String
)