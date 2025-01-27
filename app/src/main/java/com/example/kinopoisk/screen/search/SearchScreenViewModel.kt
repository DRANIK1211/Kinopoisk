package com.example.kinopoisk.screen.search

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.kinopoisk.api.Retrofit
import com.example.kinopoisk.screen.search.components.FilmSearch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch



class SearchScreenViewModel(application: Application) : AndroidViewModel(application) {
    val url = "https://festagent.com/system/tilda/tild3463-6533-4537-b061-613862363937__efecd7a587c8f1adef9d.jpg"
    val TAG = "filmSearch"
    private val _listFilms = MutableStateFlow(mutableListOf<FilmSearch>())
    var listFilms = _listFilms.asStateFlow()


    fun getSearchFilm(keyword: String) {

        viewModelScope.launch {
            var l = Retrofit.getFilmService().getFilmSearch(keyword = keyword)
            var nlist= mutableListOf<FilmSearch>()
            l.films.forEach {
                nlist.add(
                    FilmSearch(
                        name = it.nameRu,
                        imageUrl = it.posterUrl,
                        year = it.year,
                        duration = if(it.filmLength == null) "" else it.filmLength,
                        genres = it.genres.map { it.genre },
                        countrys = it.countries.map { it.country },
                        rating = if(it.rating == "null") "0" else it.rating,
                        favorites = false,
                        originalName = it.nameEn,
                        typeFilm = it.type,
                        ID = it.filmId,
                    )
                )
            }

            _listFilms.value = nlist


        }
    }

}