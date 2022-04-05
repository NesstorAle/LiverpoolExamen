package com.example.liverpoolexamen.webservice

import android.util.Log
import com.example.liverpoolexamen.common.constants.Constants
import com.example.liverpoolexamen.webservice.api.ItemApi
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WebServiceClient {
    private var retrofit: Retrofit? = null

    fun getItemsApi(): ItemApi{
        return getClient()!!.create(
            ItemApi::class.java
        )
    }

    private fun getClient(): Retrofit? {

        if (retrofit == null) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder().addInterceptor(interceptor).addInterceptor { chain ->
                    val newRequest: Request = chain.request().newBuilder()
                        .build()
                    chain.proceed(newRequest)
                }.build()

            retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }
}