package com.example.kinopoisk.screen.news

import android.app.Application
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.kinopoisk.api.Retrofit
import com.example.kinopoisk.screen.news.components.Film
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.Calendar
import java.util.Locale

class MainViewModel(application: Application) : AndroidViewModel(application) {

    var TAG = "INTERNET"
    private val _listFilms = MutableStateFlow(mutableListOf<Film>())
    var listFilms: StateFlow<MutableList<Film>> = _listFilms.asStateFlow()

    fun getCurrentYear(): Int {
        val calendar = Calendar.getInstance()
        return calendar.get(Calendar.YEAR)
    }

    fun getCurrentMonth(): String {
        val calendar = Calendar.getInstance()
        return calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH) ?: ""
    }

    fun getPremierFilms() {

        viewModelScope.launch {
            val currentYear = getCurrentYear()
            val currentMonth = getCurrentMonth()
            var l = Retrofit.getFilmService().getPremier(year = currentYear, month = currentMonth)
            Log.d(TAG,"Data recived")
            Log.d(TAG,"Data is ${l.toString()}")
            var nlist= mutableListOf<Film>()
            l.items.forEach {
                nlist.add(
                    Film(
                        name = it.nameRu,
                        imageUrl = it.posterUrlPreview,
                        year = it.year,
                        duration = it.duration.toString(),
                        genres = it.genres.map { it.genre },
                        countrys = it.countries.map { it.country },
                        premiereDate = it.premiereRu,
                        favorites = false,
                        originalName = it.nameEn,
                        id = it.kinopoiskId
                    )
                )
            }
            _listFilms.value = nlist
            Log.d(TAG,"in _list = ${_listFilms.value.toString()}")
            Log.d(TAG,"in list = ${listFilms.value.toString()}")

        }
    }



}
