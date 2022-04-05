package com.example.liverpoolexamen.webservice.responses


import com.google.gson.annotations.SerializedName

data class VariantsColor(
    @SerializedName("colorHex")
    val colorHex: String,
    @SerializedName("colorImageURL")
    val colorImageURL: String,
    @SerializedName("colorName")
    val colorName: String
)