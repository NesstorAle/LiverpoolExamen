package com.example.liverpoolexamen.webservice.responses


import com.google.gson.annotations.SerializedName

data class SortOption(
    @SerializedName("label")
    val label: String,
    @SerializedName("sortBy")
    val sortBy: String
)