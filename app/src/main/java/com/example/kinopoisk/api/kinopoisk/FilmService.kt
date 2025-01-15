package com.example.kinopoisk.api.kinopoisk

import com.example.kinopoisk.api.Retrofit
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface FilmService {

    @Headers("X-API-KEY:${Retrofit.API_KEY}")
    @GET("api/v2.2/films/premieres")
    suspend fun getPremier(@Query("year") year:Int, @Query("month") month:String): PremierResponse



}