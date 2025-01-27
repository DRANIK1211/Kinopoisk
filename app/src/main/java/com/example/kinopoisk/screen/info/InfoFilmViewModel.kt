package com.example.kinopoisk.screen.info

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.kinopoisk.api.Retrofit
import com.example.kinopoisk.screen.news.components.Film
import com.example.kinopoisk.screen.search.components.FilmSearch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class InfoFilmViewModel(application: Application) : AndroidViewModel(application) {

    private val _listFilms = MutableStateFlow<InfoFilm?>(null)
    var listFilms = _listFilms.asStateFlow()


    fun getInfo(id: Int) {


        viewModelScope.launch{
            var l = Retrofit.getFilmService().getInfoFilm(id = id)
            var nlist: InfoFilm

            nlist = InfoFilm(
                image = l.posterUrlPreview,
                nameRu = l.nameRu,
                nameOriginal = l.nameOriginal?: "",
                year = l.year,
                countries = l.countries.map { it.country },
                genres = l.genres.map { it.genre },
                filmLength = l.filmLength,
                slogan = l.slogan?: "",
                ratingK = l.ratingKinopoisk.toFloat(),
                ratingI = l.ratingImdb.toFloat(),
                ratingIVC = l.ratingImdbVoteCount,
                ratingKVC = l.ratingKinopoiskVoteCount,
                webUrl = l.webUrl,
                description = l.description,
                age = l.ratingAgeLimits,
                type = l.type
            )
            _listFilms.value = nlist
        }
    }

}