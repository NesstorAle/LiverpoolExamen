package com.example.liverpoolexamen.webservice.responses


import com.google.gson.annotations.SerializedName

data class PlpResults(
    @SerializedName("customUrlParam")
    val customUrlParam: CustomUrlParam,
    @SerializedName("label")
    val label: String,
    @SerializedName("navigation")
    val navigation: Navigation,
    @SerializedName("plpState")
    val plpState: PlpState,
    @SerializedName("records")
    val records: List<Record>,
    @SerializedName("refinementGroups")
    val refinementGroups: List<RefinementGroup>,
    @SerializedName("sortOptions")
    val sortOptions: List<SortOption>
)