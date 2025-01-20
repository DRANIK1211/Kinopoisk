package com.example.kinopoisk.api.kinopoisk

import com.example.kinopoisk.api.Retrofit
import com.example.kinopoisk.api.kinopoisk.response.FilmSearchResponse
import com.example.kinopoisk.api.kinopoisk.response.PremierResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface FilmService {

    @Headers("X-API-KEY:${Retrofit.API_KEY}")
    @GET("api/v2.2/films/premieres")
    suspend fun getPremier(@Query("year") year:Int, @Query("month") month:String): PremierResponse

    @Headers("X-API-KEY:${Retrofit.API_KEY}")
    @GET("api/v2.1/films/search-by-keyword")
    suspend fun getFilmSearch(@Query("keyword") keyword:String) : FilmSearchResponse

}