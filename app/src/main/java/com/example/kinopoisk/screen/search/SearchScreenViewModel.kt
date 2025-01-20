package com.example.kinopoisk.screen.search

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.kinopoisk.api.Retrofit
import com.example.kinopoisk.screen.search.components.FilmSearch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SearchScreenViewModel(application: Application) : AndroidViewModel(application) {
    val TAG = "filmSearch"
    private val _listFilms = MutableStateFlow(mutableListOf<FilmSearch>())
    var listFilms: StateFlow<MutableList<FilmSearch>> = _listFilms.asStateFlow()


    fun getSearchFilm(keyword: String) {

        viewModelScope.launch {
            var l = Retrofit.getFilmService().getFilmSearch(keyword = keyword)
            Log.d(TAG,"Request done")
            Log.d(TAG,"Res = ${l.toString()}")
            var nlist= mutableListOf<FilmSearch>()
            l.films.forEach {
                nlist.add(
                    FilmSearch(
                        name = it.nameRu,
                        imageUrl = it.posterUrlPreview,
                        year = Integer.parseInt(it.year),
                        duration = it.filmLength,
                        genres = it.genres.map { it.genre },
                        countrys = it.countries.map { it.country },
                        rating = it.rating,
                        favorites = false,
                        originalName = it.nameEn,
                        typeFilm = it.type
                    )
                )
            }

            _listFilms.value = nlist

        }
    }

}