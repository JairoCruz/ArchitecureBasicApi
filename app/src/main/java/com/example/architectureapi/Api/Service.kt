package com.example.architectureapi.Api

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {


    // api endpoint
    @GET("sources")
    fun getSources(
        @Query("apiKey")
        apiKey: String): Call<SourceResponse>


    companion object {

        private const val BASE_URL = "https://newsapi.org/v2/"

        fun create(): Service {

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Service::class.java)
        }

    }

}