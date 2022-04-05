package com.example.liverpoolexamen.webservice.api

import com.example.liverpoolexamen.webservice.responses.ItemResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ItemApi {

    @GET("plp?force-plp=true")
    fun getItemsRequest(
        @Query("search-string") searchString: String,
        @Query("page-number") pageNumber: String,
        @Query("number-of-items-per-page") numberOfItems: String): Call<ItemResponse>
}