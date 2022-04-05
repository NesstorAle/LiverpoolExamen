package com.example.liverpoolexamen.webservice.responses


import com.google.gson.annotations.SerializedName

data class RefinementGroup(
    @SerializedName("dimensionName")
    val dimensionName: String,
    @SerializedName("multiSelect")
    val multiSelect: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("refinement")
    val refinement: List<Refinement>
)