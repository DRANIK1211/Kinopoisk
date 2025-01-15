package com.example.kinopoisk.api

import com.example.kinopoisk.api.kinopoisk.FilmService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object Retrofit {
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://kinopoiskapiunofficial.tech/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    const val API_KEY ="7e2665b8-5ac7-4019-8dfb-9d89f3e7b2da"

    fun getFilmService() = retrofit.create(FilmService::class.java)
}