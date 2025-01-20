package com.example.kinopoisk.screen.news

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kinopoisk.screen.news.components.FilmComponents

@Composable
fun NewsScreen(){
    val viewModel: MainViewModel = viewModel<MainViewModel>()
    var listFilm = viewModel.listFilms.collectAsState()
    viewModel.getPremierFilms()
    Column (
        modifier = Modifier
            .padding(start = 17.dp, end = 19.dp)
    ){
        Text(
            text = "Новинки",
            modifier = Modifier.padding(top = 20.dp, bottom = 10.dp),
            fontSize = 27.sp,
            fontWeight = FontWeight(700)
        )


        LazyColumn() {
            items(listFilm.value) {

                FilmComponents(it)
            }
        }


    }
}

@Preview(showSystemUi = true, device = Devices.PIXEL_4)
@Composable
fun NewsScreenPreview(){
    NewsScreen()
}

