package com.example.liverpoolexamen.webservice.responses


import com.google.gson.annotations.SerializedName

data class ItemResponse(
    @SerializedName("pageType")
    val pageType: String,
    @SerializedName("plpResults")
    val plpResults: PlpResults,
    @SerializedName("status")
    val status: Status
)